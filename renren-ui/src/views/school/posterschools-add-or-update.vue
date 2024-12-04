<template>
  <el-dialog v-model="visible" :title="isEdit ? '修改' : '新增'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
      <el-form-item label="所在学校ID" prop="id">
        <el-input v-model="dataForm.id" placeholder="所在学校ID" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="学校名称" prop="unvname">
        <el-input v-model="dataForm.unvname" placeholder="学校名称"></el-input>
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
  id: '',
  unvname: ''
});


const rules = ref({
  id: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  unvname: [{ required: true, message: '必填项不能为空', trigger: 'blur' }]
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
    baseService.get(`/school/posterschools/${id}`).then((res) => {
      Object.assign(dataForm, res.data);
    });
  } else {
    // 新增时清空表单字段
    dataForm.id = '';
    dataForm.unvname = '';
  }
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }
};
// 获取编辑时的数据
const getInfo = (id: number) => {
  baseService.get("/school/posterschools/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

// 提交表单：新增或修改
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) return;

    const method = isEdit.value ? baseService.put : baseService.post;
    const url = "/school/posterschools";

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
