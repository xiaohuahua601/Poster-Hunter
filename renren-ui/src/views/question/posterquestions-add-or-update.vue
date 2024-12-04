<template>
  <el-dialog v-model="visible" :title="isEdit ? '修改' : '新增'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
      <el-form-item label="问题ID" prop="id">
        <el-input v-model="dataForm.id" placeholder="问题ID" :disabled="isEdit"></el-input>
      </el-form-item>
          <el-form-item label="海报ID" prop="posterId">
        <el-input v-model="dataForm.posterId" placeholder="海报ID"></el-input>
      </el-form-item>
          <el-form-item label="问题内容" prop="questionContent">
        <el-input v-model="dataForm.questionContent" placeholder="问题内容"></el-input>
      </el-form-item>
          <el-form-item label="问题选项" prop="choices">
        <el-input v-model="dataForm.choices" placeholder="问题选项"></el-input>
      </el-form-item>
          <el-form-item label="正确答案" prop="answer">
        <el-input v-model="dataForm.answer" placeholder="正确答案"></el-input>
      </el-form-item>
      </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle()">确定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import baseService from "@/service/baseService";
import { ElMessage } from "element-plus";
const emit = defineEmits(["refreshDataList"]);

const visible = ref(false);
const dataFormRef = ref();
const isEdit = ref(false);

const dataForm = reactive({
  id: '',  posterId: '',  questionContent: '',  choices: '',  answer: ''});

const rules = ref({
          id: [{ required: true, message: "问题ID不能为空", trigger: "blur" }],
          posterId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          questionContent: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          choices: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          answer: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ]
  });

// 初始化弹窗：新增或修改
const init = (edit: boolean, id?: number) => {
  visible.value = true;
  isEdit.value = edit;

  // 清空表单数据
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }

  if (edit && id) {
    // 修改时加载数据
    baseService.get(`/question/posterquestions/${id}`).then((res) => {
      Object.assign(dataForm, res.data);
    });
  } else {
    // 新增时清空表单
    dataForm.id = "";
    dataForm.posterId = "";
    dataForm.questionContent = "";
    dataForm.choices = "";
    dataForm.answer = "";
  }
};

// 提交表单：新增或修改
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) return;

    const method = isEdit.value ? baseService.put : baseService.post;
    const url = "/question/posterquestions";

    method(url, dataForm)
      .then(() => {
        ElMessage.success(`${isEdit.value ? "修改" : "新增"}成功`);
        visible.value = false; // 关闭弹窗
        emit("refreshDataList"); // 刷新列表
      })
      .catch((err) => {
        ElMessage.error(err.message || "操作失败");
      });
  });
};

defineExpose({
  init
});
</script>
