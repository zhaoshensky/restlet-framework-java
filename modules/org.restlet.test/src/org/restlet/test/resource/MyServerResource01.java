/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL
 * 1.0 (the "Licenses"). You can select the license that you prefer but you may
 * not use this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package org.restlet.test.resource;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;

/**
 * Sample server resource.
 * 
 * @author Jerome Louvel
 */
public class MyServerResource01 extends ServerResource implements MyResource01 {

    public static void main(String[] args) throws Exception {
        Server server = new Server(Protocol.HTTP, 8111);
        server.setNext(MyServerResource01.class);
        server.start();
    }

    private volatile MyBean myBean = new MyBean("myName", "myDescription");

    public boolean accept(MyBean bean) {
        return bean.equals(myBean);
    }

    public String describe() {
        return "MyDescription";
    }

    public String remove() {
        myBean = null;
        return "Done";
    }

    public MyBean represent() {
        return myBean;
    }

    public String store(MyBean bean) {
        myBean = bean;
        return "Done";
    }

}