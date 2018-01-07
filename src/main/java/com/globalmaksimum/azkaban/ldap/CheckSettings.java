package com.globalmaksimum.azkaban.ldap;

import azkaban.user.User;
import azkaban.user.UserManagerException;
import azkaban.utils.Props;
import net.researchgate.azkaban.LdapUserManager;

import java.io.IOException;

public class CheckSettings {
    private static final String LDAP_CHECK_TRUEUSERNAME = "user.manager.ldap.test.trueusername";
    private static final String LDAP_CHECK_TRUEPASSWORD = "user.manager.ldap.test.truepassword";

    public static void main(String[] args) throws IOException, UserManagerException {
        Props p = new Props(null, args[0]);
        LdapUserManager lum = new LdapUserManager(p);

        User user = lum.getUser(p.getString(LDAP_CHECK_TRUEUSERNAME), p.getString(LDAP_CHECK_TRUEPASSWORD));
        user.getGroups().stream().forEach(u-> System.out.println(u));
        System.out.println("checking finished "+user.toString());
    }
}
