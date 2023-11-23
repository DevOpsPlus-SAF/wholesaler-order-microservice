package com.example.wholesalerorder.wholesalerorders.mapping;

import com.example.wholesalerorder.tools.mapping.EnhancedModelMapper;
import com.example.wholesalerorder.wholesalerorders.domain.model.entity.WholesalerOrder;
import com.example.wholesalerorder.wholesalerorders.resource.CreateWholesalerOrderResource;
import com.example.wholesalerorder.wholesalerorders.resource.UpdateWholesalerOrderResource;
import com.example.wholesalerorder.wholesalerorders.resource.WholesalerOrderResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WholesalerOrderMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public WholesalerOrderResource toResource(WholesalerOrder model){
        return mapper.map(model, WholesalerOrderResource.class);
    }

    public WholesalerOrder toModel(CreateWholesalerOrderResource resource){
        return mapper.map(resource, WholesalerOrder.class);
    }

    public WholesalerOrder toModel(UpdateWholesalerOrderResource resource){
        return mapper.map(resource, WholesalerOrder.class);
    }

    public List<WholesalerOrderResource> toResource(List<WholesalerOrder> model){
        return mapper.mapList(model, WholesalerOrderResource.class);
    }

}
