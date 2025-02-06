<template>
  <el-dialog v-model="visible" :title="isEdit ? '修改' : '新增'" :close-on-click-modal="true" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="rules" ref="dataFormRef" @keyup.enter="dataFormSubmitHandle" label-width="120px">
      <el-form-item label="用户ID" prop="id">
        <el-input v-model="dataForm.id" placeholder="用户ID" :disabled="isEdit"></el-input>
      </el-form-item>
      <!-- <el-form-item label="用户身份" prop="identity">
        <el-select v-model="dataForm.identity" placeholder="选择用户身份">
          <el-option label="student" value="student"></el-option>
          <el-option label="visitor" value="visitor"></el-option>
          <el-option label="faculty" value="faculty"></el-option>
        </el-select>
      </el-form-item> -->
      <el-form-item prop="identity" label="性别">
        <ren-radio-group v-model="dataForm.identity" dict-type="identity"></ren-radio-group>
      </el-form-item>
          <el-form-item v-if="dataForm.identity === 'student'" label="学号" prop="studentId">
            <el-input v-model="dataForm.studentId" placeholder="学号"></el-input>
          </el-form-item>
          <el-form-item v-if="dataForm.identity === 'faculty'" label="教职工编号" prop="facultyId">
            <el-input v-model="dataForm.facultyId" placeholder="教职工编号"></el-input>
          </el-form-item>
      <el-form-item label="手机号" prop="mobilePhoneNumber">
        <el-input v-model="dataForm.mobilePhoneNumber" placeholder="手机号"></el-input>
      </el-form-item>
      <el-form-item label="用户昵称" prop="nickname">
        <el-input v-model="dataForm.nickname" placeholder="用户昵称"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="dataForm.password" placeholder="密码"></el-input>
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
  id: '', 
  identity: '', 
  studentId: "", 
  facultyId: '', 
  mobilePhoneNumber: '', 
  nickname: '', 
  password: '', 
  isAdmin: '', 
  isOnline: '',
  schoolId: ''
});

const rules = ref({
  id: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  identity: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  studentId: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  facultyId: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  mobilePhoneNumber: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  nickname: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  password: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  isAdmin: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  isOnline: [{ required: true, message: '必填项不能为空', trigger: 'blur' }],
  schoolId: [{ required: true, message: '必填项不能为空', trigger: 'blur' }]
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
    baseService.get(`/user/posterusers/${id}`).then((res) => {
      Object.assign(dataForm, res.data);
    });
  } else {
    // 新增时清空表单字段
    dataForm.id = '';
    dataForm.identity = '';
    dataForm.studentId = '', 
    dataForm.facultyId = '', 
    dataForm.mobilePhoneNumber = '';
    dataForm.nickname = '';
    dataForm.password = '';
    dataForm.isAdmin = '';
    dataForm.isOnline = '';
    dataForm.schoolId = '';
  }
  if (dataFormRef.value) {
    dataFormRef.value.resetFields();
  }
};

// 提交表单：新增或修改
const dataFormSubmitHandle = () => {
  dataFormRef.value.validate((valid: boolean) => {
    if (!valid) return;

    const method = isEdit.value ? baseService.put : baseService.post;
    const url = "/user/posterusers";
    const url1 = "/student/posterstudents";
    const url2 = "/faculty/posterfaculties";
    const url3 = "/visitor/postervisitors";

      method(url, dataForm)
        .then(() => {
          ElMessage.success(`${isEdit.value ? "修改" : "新增"}成功`);
          visible.value = false; // 关闭弹窗
          emit("refreshDataList"); // 刷新列表
          const dataForm1 = {
            id: dataForm.id,
            studentId: dataForm.studentId
          };
          const dataForm2 = {
            id: dataForm.id,
            facultyId: dataForm.facultyId
          };
          const dataForm3 = {
            id: dataForm.id,
          };
// console.log(dataForm.id + " ********** " + dataForm3.id );
// console.log(dataForm.studentId + " ********** " + dataForm1.studentId );

          setTimeout(() => {
            if (dataForm.identity == "student") {
              method(url1, dataForm1)
                .then(() => {
                  ElMessage.success(`${isEdit.value ? "修改" : "新增"}关联成功`);
                })
                .catch((err) => {
                  ElMessage.error(err.message || "关联操作失败");
                });
            }
            else if(dataForm.identity == "faculty") {
              method(url2, dataForm2)
              .then(() => {
                ElMessage.success(`${isEdit.value ? "修改" : "新增"}关联成功`);
              })              
              .catch((err) => {
                ElMessage.error(err.message || "关联操作失败");
              });
            }
            else if(dataForm.identity == "visitor") {
              method(url3, dataForm3)
              .then(() => {
                ElMessage.success(`${isEdit.value ? "修改" : "新增"}关联成功`);
              })
              .catch((err) => {
                ElMessage.error(err.message || "关联操作失败");
              });
            }
          }, 1000); // 3000毫秒后更新
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


