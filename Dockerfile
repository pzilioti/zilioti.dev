FROM quay.io/wildfly/wildfly:24.0.0.Final
ADD /database/mysql-connector-java-8.0.20.jar /opt/jboss/wildfly/standalone/deployments/
ADD /target/*.war /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0" ]