UnitsService
============

Operating with different types of wariors

To install service:
-------------------
1. From project root folder build maven projects
> mvn clean install
2. Unzip pure Karaf and start it.
3. Deploy features.xml for unit project
karaf@root()> feature:repo-add  mvn:ua.ishchenko/unit-feature/1.0.0/xml/features
4. Add cxf repository, in Karaf console:
karaf@root()> feature:repo-add cxf 3.0.1
5. Start unit service
karaf@root()> feature:install unit-service
