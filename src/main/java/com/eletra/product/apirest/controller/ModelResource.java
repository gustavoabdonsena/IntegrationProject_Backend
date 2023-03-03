package com.eletra.product.apirest.controller;


import com.eletra.product.apirest.model.LineupEntity;
import com.eletra.product.apirest.model.ModelEntity;
import com.eletra.product.apirest.repository.IModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Model")
@CrossOrigin(origins = "*") // deixa que todos os domínios podem acessar, poderia ser mais estrita como https://dominio...
public class ModelResource {

    @Autowired
    IModel iModel;

    @ApiOperation(value = "Return an list of Model of an specific Category")
    @GetMapping("/models/{categoryName}")
    public List<ModelEntity> findByCategoryNameIgnoreCase(@PathVariable(value = "categoryName") String categoryName){
        return  iModel.findByCategoryNameIgnoreCase(categoryName);
    }
    @ApiOperation(value = "Save a new Model")
    @PutMapping("/model")
    public ModelEntity saveNewModel(@RequestBody ModelEntity modelEntity){
        return iModel.save(modelEntity);
    }

    @ApiOperation(value = "Save a new Model")
    @DeleteMapping("/model")
    public void deleteModel(@RequestBody ModelEntity modelEntity){
        iModel.delete(modelEntity);
    }
}
