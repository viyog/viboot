package indi.viyoung.viboot.mybatis.dao;

import java.util.List;


public interface BaseDao {

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForList(String str, Object obj);

    /**
     * 保存对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    int insert(String str, Object obj);

    /**
     * 批量保存对象
     *
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    int batchInsert(String str, List<?> objs);

    /**
     * 修改对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    int update(String str, Object obj);

    /**
     * 批量修改对象
     *
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    void batchUpdate(String str, List<?> objs);

    /**
     * 批量修改对象(通过sql的case/when拼接)
     *
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    int batchUpdateCaseWhen(String str, List<?> objs);

    /**
     * 删除对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    int delete(String str, Object obj);

    /**
     * 批量删除对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    int batchDelete(String str, List<?> objs);

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForObject(String str, Object obj);

    /**
     * 查找对象
     *
     * @param str
     * @return
     * @throws Exception
     */
    Object findForObject(String str);


    /**
     * 查找对象封装成Map
     *
     * @param s
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key, String value);

}
