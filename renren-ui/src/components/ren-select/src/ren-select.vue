<template>
  <el-select v-model="value" @change="$emit('update:modelValue', $event)" :placeholder="placeholder" clearable>
    <el-option :label="data.dictLabel" v-for="data in dataList" :key="data.dictValue" :value="data.dictValue">{{ data.dictLabel }}</el-option>
  </el-select>
</template>

<script lang="ts">
import { computed, defineComponent, watch } from "vue";
import { getDictDataList } from "@/utils/utils";
import { useAppStore } from "@/store";

export default defineComponent({
  name: "RenSelect",
  props: {
    modelValue: [Number, String],
    dictType: String,
    placeholder: String
  },
  setup(props, { emit }) {
    const store = useAppStore();
    const dataList = getDictDataList(store.state.dicts, props.dictType);
    const value = computed({
      get: () => props.modelValue ?? '',
      set: (newValue) => {
        if (newValue === null || newValue === '') {
          emit('update:modelValue', null);
        } else {
          emit('update:modelValue', newValue);
        }
      }
    });

    return {
      value,
      dataList
    };
  }
});
</script>
<!-- <template>
  <el-select v-model="value" @change="$emit('update:modelValue', $event)" :placeholder="placeholder" clearable>
    <el-option :label="data.dictLabel" v-for="data in dataList" :key="data.dictValue" :value="data.dictValue">{{ data.dictLabel }}</el-option>
  </el-select>
</template>
<script lang="ts">
import { computed, defineComponent } from "vue";
import { getDictDataList } from "@/utils/utils";
import { useAppStore } from "@/store";
export default defineComponent({
  name: "RenSelect",
  props: {
    modelValue: [Number, String],
    dictType: String,
    placeholder: String
  },
  setup(props) {
    const store = useAppStore();
    return {
      value: computed(() => `${props.modelValue}`),
      dataList: getDictDataList(store.state.dicts, props.dictType)
    };
  }
});
</script> -->
