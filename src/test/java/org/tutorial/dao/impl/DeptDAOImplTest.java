package org.tutorial.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DeptDAO;
import dao.impl.DeptDAOImpl;
import model.DeptDO;
import model.EmpDO;

public class DeptDAOImplTest {

    private static DeptDAO dao;

    @BeforeClass
    public static void init() {
        dao = new DeptDAOImpl();
    }

    @Test
    public void insert() {
        DeptDO deptDO1 = new DeptDO();
        deptDO1.setDname("製造部");
        deptDO1.setLoc("美國洛杉磯");
        dao.insert(deptDO1);
        assertTrue(true);
    }

    @Test
    public void update() {
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(10);
        deptDO.setDname("財務部2");
        deptDO.setLoc("臺灣台北2");
        dao.update(deptDO);
        assertTrue(true);
    }

    @Test
    public void delete() {
        dao.delete(10);
        assertTrue(true);
    }

    @Test
    public static void findByPrimaryKey() {
        DeptDO deptDO = dao.findByPrimaryKey(20);
        assertEquals(Integer.valueOf(20), deptDO.getDeptno());
        assertEquals("研發部", deptDO.getDname());
        assertEquals("臺灣新竹", deptDO.getLoc());
    }

    @Test
    public static void getAll() {
        List<DeptDO> list = dao.getAll();
        for (DeptDO deptDO : list) {
            System.out.print(deptDO.getDeptno() + ",");
            System.out.print(deptDO.getDname() + ",");
            System.out.print(deptDO.getLoc());
            System.out.println();
        }
    }

    @Test
    public static void getEmpsByDeptno() {
        List<EmpDO> list = dao.getEmpsByDeptno(10);
        for (EmpDO empDO : list) {
            System.out.print(empDO.getEmpno() + ",");
            System.out.print(empDO.getEname() + ",");
            System.out.print(empDO.getJob() + ",");
            System.out.print(empDO.getHiredate() + ",");
            System.out.print(empDO.getSal() + ",");
            System.out.print(empDO.getComm() + ",");
            System.out.print(empDO.getDeptno());
            System.out.println();
        }

    }

}
