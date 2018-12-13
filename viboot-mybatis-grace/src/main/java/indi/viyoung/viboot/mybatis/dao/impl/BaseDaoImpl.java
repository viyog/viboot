package indi.viyoung.viboot.mybatis.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import indi.viyoung.viboot.mybatis.dao.BaseDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


/**
 * <pre>
 * 对象功能:BaseDao接口实现类
 * 开发人员:lixin
 * 创建时间:2018-01-15
 * </pre>
 */
@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public int insert(String str, Object obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 批量更新
     *
     * @param str
     * @param objs
     * @return
     */
    @Override
    public int batchInsert(String str, List<?> objs) {
        return sqlSessionTemplate.insert(str, objs);
    }

    /**
     * 修改对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public int update(String str, Object obj) {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 批量更新
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public void batchUpdate(String str, List<?> objs) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        // 批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            if (objs != null) {
                for (int i = 0, size = objs.size(); i < size; i++) {
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量修改对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public int batchUpdateCaseWhen(String str, List<?> objs) {
        return sqlSessionTemplate.update(str, objs);
    }

    /**
     * 批量更新
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public int batchDelete(String str, List<?> objs) {
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 删除对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public int delete(String str, Object obj) {
        return sqlSessionTemplate.delete(str, obj);
    }

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object findForObject(String str) {
        return sqlSessionTemplate.selectOne(str);
    }

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     */
    @Override
    public Object findForList(String str, Object obj) {
        return sqlSessionTemplate.selectList(str, obj);
    }

    @Override
    public Object findForMap(String str, Object obj, String key, String value) {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

}
