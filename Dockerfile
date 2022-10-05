FROM mariadb:latest

ENV MYSQL_ROOT_PASSWORD rootdocker
ENV MYSQL_USER rootdocker
ENV MYSQL_PASSWORD rootdocker

EXPOSE 3307

CMD ["mysqld"]