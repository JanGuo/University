package com.janguo.carsystem.dao;

import com.janguo.carsystem.domain.VictualerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VictualerDao {
    /**
     *     // 供应商编号
     *     private String providerId;
     *     // 供应商名称
     *     private String victualerName;
     *     // 供应商地址
     *     private String victualerAddress;
     *     // 供应商电话
     *     private String victualerTel;
     *     // 供应商开户行编号
     *     private String victualerBank;
     *     // 供应商账号
     *     private String victualerBankId;
     *     // 供应商备注
     *     private String victualerRemark;
     * @return
     */
    @Results(id = "victualer",value = {
            @Result(property = "victualerId",column = "victualer_id"),
            @Result(property = "victualerName",column = "victualer_name"),
            @Result(property = "victualerAddress",column = "victualer_address"),
            @Result(property = "victualerTel",column = "victualer_tel"),
            @Result(property = "victualerBank",column = "victualer_bank"),
            @Result(property = "victualerBankId",column = "victualer_bank_id"),
            @Result(property = "victualerRemark",column = "victualer_remark")
    })
    @Select("select * from victualer")
    List<VictualerEntity> getAllVictualer();

    boolean addVictualer();
}
