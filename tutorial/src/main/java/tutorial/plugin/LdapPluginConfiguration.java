package tutorial.plugin;

import org.camunda.bpm.identity.impl.ldap.LdapConfiguration;

public class LdapPluginConfiguration extends LdapConfiguration {

	public LdapPluginConfiguration(String serverUrl, String managerDn, String managerPassword, String baseDn, String userSearchBase, String userSearchFilter, String userIdAttribute, String userFirstnameAttribute, String userLastnameAttribute, 
			String userEmailAttribute, String userPasswordAttribute, String groupSearchBase, String groupSearchFilter, String groupIdAttribute, String groupNameAttribute, String groupMemberAttribute) {
		this.serverUrl = serverUrl;
		this.managerDn = managerDn;
		this.managerPassword = managerPassword;
		this.baseDn = baseDn;
		this.userSearchBase = userSearchBase;
		this.userSearchFilter = userSearchFilter;
		this.userIdAttribute = userIdAttribute;
		this.userFirstnameAttribute = userFirstnameAttribute;
		this.userLastnameAttribute = userLastnameAttribute;
		this.userEmailAttribute = userEmailAttribute;
		this.userPasswordAttribute = userPasswordAttribute;
		this.groupSearchFilter = groupSearchFilter;
		this.groupIdAttribute = groupIdAttribute;
		this.groupNameAttribute = groupNameAttribute;
		this.groupMemberAttribute = groupMemberAttribute;
	}
	
	public LdapPluginConfiguration(String serverUrl, String managerDn, String managerPassword) {
		this.serverUrl = serverUrl;
		this.managerDn = managerDn;
		this.managerPassword = managerPassword;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
