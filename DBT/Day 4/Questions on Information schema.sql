use information_schema;
#1
show tables from information_schema;
select table_name from tables where table_schema = 'scott' ;

select table_name, column_name,data_type 
from columns where table_schema = 'scott';

show tables from information_schema like '%col%';

