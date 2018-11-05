package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.DetailBillDTO;
import com.hoaiduc.core.dto.DetailBillIdDTO;
import com.hoaiduc.core.persistence.data.entity.DetailBill;
import org.modelmapper.ModelMapper;

public class DetailConvert
{
    private ModelMapper modelMapper=new ModelMapper();
    public DetailBillDTO convertDetailBillDTO(DetailBill detailBill)
    {
        DetailBillDTO detailBillDTO=new DetailBillDTO();
        DetailBillIdDTO detailBillIdDTO=new DetailBillIdDTO();
        detailBillIdDTO.setIdBill(detailBill.getDetailBillId().getIdBill());
        detailBillIdDTO.setIdDetailProduct(detailBill.getDetailBillId().getIdDetailProduct());
        detailBillDTO.setDetailBillIdDTO(detailBillIdDTO);
        modelMapper.map(detailBill,detailBillDTO);
        return detailBillDTO;
    }
}
