package edu.eci.cvds;

import org.junit.Before;
import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISClienteDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISItemDao;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISTipoItemDAO;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.impl.ServiciosAlquilerImpl;
import edu.eci.cvds.samples.services.impl.*;

public class TestBase {
    protected Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("test");
                setClassPathResource("mybatis-config-h2.xml");
                
                bind(ClienteDAO.class).to(MyBATISClienteDAO.class);
                bind(ItemDAO.class).to(MyBATISItemDao.class);
                bind(TipoItemDAO.class).to(MyBATISTipoItemDAO.class);
                bind(ItemRentadoDAO.class).to(MyBATISItemRentadoDAO.class);
                bind(ServiciosAlquiler.class).to(ServiciosAlquilerImpl.class);
                
            }
    });
    
    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}