package io.renren.modules.faculty.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.faculty.dto.PosterFacultiesDTO;
import io.renren.modules.faculty.excel.PosterFacultiesExcel;
import io.renren.modules.faculty.service.PosterFacultiesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 教职工信息管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-12-03
 */
@RestController
@RequestMapping("faculty/posterfaculties")
@Tag(name="教职工信息管理")
public class PosterFacultiesController {
    @Autowired
    private PosterFacultiesService posterFacultiesService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @Parameters({
        @Parameter(name = Constant.PAGE, description = "当前页码，从1开始", in = ParameterIn.QUERY, required = true, ref="int") ,
        @Parameter(name = Constant.LIMIT, description = "每页显示记录数", in = ParameterIn.QUERY,required = true, ref="int") ,
        @Parameter(name = Constant.ORDER_FIELD, description = "排序字段", in = ParameterIn.QUERY, ref="String") ,
        @Parameter(name = Constant.ORDER, description = "排序方式，可选值(asc、desc)", in = ParameterIn.QUERY, ref="String")
    })
    @RequiresPermissions("faculty:posterfaculties:page")
    public Result<PageData<PosterFacultiesDTO>> page(@Parameter(hidden = true) @RequestParam Map<String, Object> params){
        PageData<PosterFacultiesDTO> page = posterFacultiesService.page(params);

        return new Result<PageData<PosterFacultiesDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @RequiresPermissions("faculty:posterfaculties:info")
    public Result<PosterFacultiesDTO> get(@PathVariable("id") Long id){
        PosterFacultiesDTO data = posterFacultiesService.get(id);

        return new Result<PosterFacultiesDTO>().ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @LogOperation("保存")
    @RequiresPermissions("faculty:posterfaculties:save")
    public Result save(@RequestBody PosterFacultiesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        posterFacultiesService.save(dto);

        return new Result();
    }

    @PutMapping
    @Operation(summary = "修改")
    @LogOperation("修改")
    @RequiresPermissions("faculty:posterfaculties:update")
    public Result update(@RequestBody PosterFacultiesDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        posterFacultiesService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @LogOperation("删除")
    @RequiresPermissions("faculty:posterfaculties:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        posterFacultiesService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @Operation(summary = "导出")
    @LogOperation("导出")
    @RequiresPermissions("faculty:posterfaculties:export")
    public void export(@Parameter(hidden = true) @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<PosterFacultiesDTO> list = posterFacultiesService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "教职工信息管理", list, PosterFacultiesExcel.class);
    }

}
