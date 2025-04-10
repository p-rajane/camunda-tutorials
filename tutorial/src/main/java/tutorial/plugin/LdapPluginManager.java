package tutorial.plugin;

import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.identity.impl.ldap.LdapIdentityProviderFactory;
import org.camunda.bpm.identity.impl.ldap.plugin.LdapIdentityProviderPlugin;
import org.springframework.stereotype.Component;

//@Component
public class LdapPluginManager extends LdapIdentityProviderPlugin {

	@Override
	public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
		LdapPluginConfiguration configuration = new LdapPluginConfiguration("ldap://www.btechldap.com:1389/", "cn=readonlybind,ou=admins,dc=btechsample,dc=com", "btechpass");
		LdapIdentityProviderFactory ldapIdentityProviderFactory = new LdapIdentityProviderFactory();
		ldapIdentityProviderFactory.setLdapConfiguration(configuration);
		processEngineConfiguration.setIdentityProviderSessionFactory(ldapIdentityProviderFactory);
	}

}
