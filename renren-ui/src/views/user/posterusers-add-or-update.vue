<template>
  <el-dialog v-model="visible" :title="isEdit ? '修改' : '新增'" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle" label-width="120px">
      <el-form-item label="用户ID" prop="id">
        <el-input v-model="dataForm.id" placeholder="用户ID" :disabled="isEdit"></el-input>
      </el-form-item>
      <el-form-item label="用户身份" prop="identity">
        <el-input v-model="dataForm.identity" placeholder="用户身份"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="mobilePhoneNumber">
        <el-input v-model="dataForm.mobilePhoneNumber" placeholder="手机号"></el-input>
      </el-form-item>
      <el-form-item label="用户昵称" prop="nickname">
        <el-input v-model="dataForm.nickname" placeholder="用户昵称"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="dataForm.password" placeholder="密码" type="password"></el-input>
      </el-form-item>
      <el-form-item label="是否为管理员" prop="isAdmin">
        <el-input v-model="dataForm.isAdmin" placeholder="是否为管理员"></el-input>
      </el-form-item>
      <el-form-item label="是否在线" prop="isOnline">
        <el-input v-model="dataForm.isOnline" placeholder="是否在线"></el-input>
      </el-form-item>
      <el-form-item label="所在学校ID" prop="schoolId">
        <el-input v-model="dataForm.schoolId" placeholder="所在学校ID"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle">确定</el-button>
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
  id: '', identity: '', mobilePhoneNumber: '', nickname: '', password: '', isAdmin: '0', isOnline: '0', schoolId: ''
});

const rules = reactive({
  id: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  identity: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  mobilePhoneNumber: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  nickname: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  password: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  isAdmin: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  isOnline: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  schoolId: [{ required: true, message: '必填项不能为空', trigger: 'blur' }]
});

const init = (edit: boolean, id?: number) => {
  visible.value = true;
  isEdit.value = edit;
  if (edit) {
    dataForm.id = id.toString();
    getInfo(id);
  } else {
    dataForm.id = ''; // 新增时清空id
  }
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }
};

const getInfo = (id: number) => {
  baseService.get("/user/posterusers/" + id).then((res) => {
    Object.assign(dataForm, res.data);
  });
};

const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) {
      ElMessage.error('表单验证失败');
      return false;
    }
    const method = isEdit.value ? baseService.put : baseService.post;
    method("/user/posterusers", dataForm).then(() => {
      ElMessage.success(isEdit.value ? '更新成功' : '新增成功');
      visible.value = false;
      emit("refreshDataList");
    }).catch((error) => {
      ElMessage.error('操作失败: ' + error.message);
    });
  });
};

defineExpose({
  init
});
</script>
