package dao;

import entity.OrderRecord;

public interface OrderRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    int insert(OrderRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    int insertSelective(OrderRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    OrderRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderRecord record);
}