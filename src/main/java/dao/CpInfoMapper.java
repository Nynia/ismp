package dao;

import entity.CpInfo;

import java.util.List;

public interface CpInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    int insert(CpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    int insertSelective(CpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    CpInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CpInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CpInfo record);

    List<CpInfo> selectAllCpInfos();
}