package ru.sample.model;

import java.io.OutputStream;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import javax.naming.Context;
import javax.naming.InitialContext;

@MessageDriven(mappedName = "jms/ForumTopic", activationConfig = 
               { @ActivationConfigProperty(propertyName = "connectionFactoryJndiName",
                                           propertyValue = "jms/TopicFactory"),
                 @ActivationConfigProperty(propertyName = "destinationName",
                                           propertyValue = "jms/ForumTopic"),
                 @ActivationConfigProperty(propertyName = "destinationType",
                                           propertyValue = "javax.jms.Topic")
                                          })
public class MDBReportBean implements MessageListener {

//    String prefix = "java:comp/env/";
//    String ejbRefName = "GetReportBean";
//    String jndiUrl = prefix + ejbRefName;    //The JNDI URL should be "java:comp/env/GetReportBean"
    
//    @EJB
//    private GetReportLocal gr;
    
    public void onMessage(Message message) {
        try {
//            Context ctx = new InitialContext();
            
          System.out.println("-=-=-=-=-=-= MDB CREATED =-=-=-=-=-=-" + ((TextMessage)message).getText());
//          javax.naming.Context ctx = new javax.naming.InitialContext();
//          while (ctx.list(prefix).hasMoreElements()) {
//                System.out.println(ctx.list(prefix).nextElement());
//            }
            
//          GetReportLocal sf2 = ( GetReportLocal ) ctx.lookup( prefix + "" + ejbRefName );

//            sf2.ShowData("Hello2");            
            
//            gr.ShowData("Hello");
//            Context ctx = null;
//            Connection conn = null;
//            OutputStream out = null;
//            try {
//                ctx = new InitialContext();
//                ctx.rebind("report/flag", new Integer(5));
//                //////////////////Report
////                RTFProcessor rtf = null;
////                DataProcessor data = null;
////                FOProcessor fo = null;
//                ctx.rebind("report/flag", new Integer(10));
////                data = new DataProcessor();
//                Class.forName("org.postgresql.Driver");
//                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "post1", "612488");
////                data.setConnection(conn);
//            } catch (Exception e) {
//            System.out.println(e);
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//      System.out.println("-=-=-=-=-=-= MDB DESTROYED=-=-=-=-=-=-");
}
