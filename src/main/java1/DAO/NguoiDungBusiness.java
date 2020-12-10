package DAO;

import java.util.List;

import org.hibernate.Session;

import enity.NguoiDung;

public class NguoiDungBusiness {
    public List<NguoiDung> listNguoiDung(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List lstNguoiDung = session.createQuery("from NguoiDung").list();
        
            session.getTransaction().commit();
            session.close();
            return lstNguoiDung;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    public NguoiDung findNguoiDung(String tenDN){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            NguoiDung uniqueResult = (NguoiDung) session.createQuery("from NguoiDung where TenDangNhap = :TenDangNhap").setParameter("TenDangNhap",tenDN).uniqueResult();      
            session.getTransaction().commit();
            session.close();
            return uniqueResult;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    public boolean deleteNguoiDung(NguoiDung objNguoiDung){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from NguoiDung where TenDangNhap = :TenDangNhap")
                    .setParameter("TenDangNhap", objNguoiDung.tenDangNhap)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0) return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }
    
    public boolean addNguoiDung(NguoiDung objNguoiDung){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(objNguoiDung);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }
    
    public boolean updateNguoiDung(NguoiDung objNguoiDung){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(objNguoiDung);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }    
}
