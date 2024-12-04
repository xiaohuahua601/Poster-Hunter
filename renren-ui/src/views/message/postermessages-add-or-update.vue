<template>
  <el-dialog v-model="visible" :title="isEdit ? '修改' : '新增'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle()" label-width="120px">
      <el-form-item label="消息编号" prop="id">
        <el-input v-model="dataForm.id" placeholder="消息编号" :disabled="isEdit"></el-input>
      </el-form-item>
          <el-form-item label="所在学校ID" prop="schoolId">
        <el-input v-model="dataForm.schoolId" placeholder="所在学校ID"></el-input>
      </el-form-item>
          <el-form-item label="消息标题" prop="messageTitle">
        <el-input v-model="dataForm.messageTitle" placeholder="消息标题"></el-input>
      </el-form-item>
          <el-form-item label="消息内容" prop="messageContent">
        <el-input v-model="dataForm.messageContent" placeholder="消息内容"></el-input>
      </el-form-item>
          <el-form-item label="接收者ID" prop="receiverUid">
        <el-input v-model="dataForm.receiverUid" placeholder="接收者ID"></el-input>
      </el-form-item>
          <el-form-item label="发送时间" prop="sendTime">
        <el-input v-model="dataForm.sendTime" placeholder="发送时间"></el-input>
      </el-form-item>
          <el-form-item label="是否为官方消息" prop="isOfficial">
        <el-input v-model="dataForm.isOfficial" placeholder="是否为官方消息"></el-input>
      </el-form-item>
          <el-form-item label="是否已读" prop="isRead">
        <el-input v-model="dataForm.isRead" placeholder="是否已读"></el-input>
      </el-form-item>
          <el-form-item label="已接受者ID列表" prop="receivedUid">
        <el-input v-model="dataForm.receivedUid" placeholder="已接受者ID列表"></el-input>
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
const isEdit = ref(false); // 是否为修改操作

const dataForm = reactive({
  id: '',  schoolId: '',  messageTitle: '',  messageContent: '',  receiverUid: '',  sendTime: '',  isOfficial: '',  isRead: '',  receivedUid: ''});

const rules = ref({
          id: [{ required: true, message: "消息ID不能为空", trigger: "blur" }],
          schoolId: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          messageTitle: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          messageContent: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
          receiverUid: [
      { required: true, message: '必填项不能为空', trigger: 'blur' }
    ],
    //       sendTime: [
    //   { required: true, message: '必填项不能为空', trigger: 'blur' }
    // ],
    //       isOfficial: [
    //   { required: true, message: '必填项不能为空', trigger: 'blur' }
    // ],
    //       isRead: [
    //   { required: true, message: '必填项不能为空', trigger: 'blur' }
    // ],
          receivedUid: [
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
    baseService.get(`/message/postermessages/${id}`).then((res) => {
      Object.assign(dataForm, res.data);
    });
  } else {
    // 新增时清空表单
    dataForm.id = "";
    dataForm.schoolId = "";
    dataForm.messageTitle = "";
    dataForm.messageContent = "";
    dataForm.receiverUid = "";
    dataForm.sendTime = "";
    dataForm.isOfficial = "";
    dataForm.isRead = "";
    dataForm.receivedUid = "";
  }
};

// 提交表单：新增或修改
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) return;

    const method = isEdit.value ? baseService.put : baseService.post;
    const url = "/message/postermessages";

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
