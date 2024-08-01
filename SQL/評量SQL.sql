--實作練習2
create table OFFICE (
    轄管分局代碼 VARCHAR2(20),
    分局地址 NVARCHAR2(100),
    分局聯絡電話 VARCHAR2(20),
    轄管分局 NVARCHAR2(100));

create table OFFICE_INFO (
    類別 VARCHAR2(20),
    避難設施地址 NVARCHAR2(100),
    容人數量 NUMBER(13,0),
    地下樓層數  NUMBER(8,0),
    轄管分局代碼 VARCHAR2(20),
    村里別代號 VARCHAR2(20));
    
create table COUNTRY_INFO (
    村里別代號 VARCHAR2(20),
    村里別 NVARCHAR2(100),
    村里辦公室位置 NVARCHAR2(100),
    村里辦公室電話 VARCHAR2(20));
    
--實作練習3
insert into STUDENT.OFFICE ( 轄管分局代碼, 分局地址, 分局聯絡電話, 轄管分局) values ('M001', '苗栗縣竹南鎮民族街72號', '03 747 4796', '竹南分局');
insert into STUDENT.OFFICE ( 轄管分局代碼, 分局地址, 分局聯絡電話, 轄管分局) values ('M002', '苗栗縣苗栗市金鳳街109號', '03 732 0059', '苗栗分局');
insert into STUDENT.OFFICE ( 轄管分局代碼, 分局地址, 分局聯絡電話, 轄管分局) values ('M003', '苗栗縣頭份市中興路503號', '03 766 3004', '頭份分局');
commit;

insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公寓', '苗栗縣竹南鎮中埔街20號', '100', '1',  'MOO1', 'C001');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('大樓', '苗栗縣竹南鎮和平街79號', '3142', '1',  'MOO1', 'C002');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('大樓', '苗栗縣竹南鎮龍山路三段142號', '1072', '1',  'MOO1', 'C003');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公共設施', '苗栗縣後龍鎮中華路1498號', '32', '1',  'MOO1', 'C004');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公寓', '苗栗縣苗栗市米市街80號', '106', '1',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公寓', '苗栗縣苗栗市光復路117號', '26', '1',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('大樓', '苗栗縣苗栗市博愛街109號', '2038', '2',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('大樓', '苗栗縣苗栗市大同路53號', '128', '2',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公共設施', '苗栗縣頭份市民族里和平路102號', '353', '1',  'MOO3', 'C006');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('私營單位', '苗栗縣頭份市忠孝忠孝一路69號', '501', '1',  'MOO3', 'C007');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('公寓', '苗栗縣頭份市信義里中正路65號', '194', '1',  'MOO3', 'C008');
insert into STUDENT.OFFICE_INFO ( 類別, 避難設施地址, 容人數量, 地下樓層數, 轄管分局代碼, 村里別代號) values ('私營單位', '苗栗縣頭份市信義里中正路116號', '78', '1',  'MOO3', 'C008');
commit;

insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C001', '大埔里', '竹南鎮公義路1035號', '03 758 1072');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C002', '竹南里', '竹南鎮竹南里中山路103號', '037-472735');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C003', '山佳里', '竹南鎮山佳里國光街14號', '037-614186');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C004', '頂埔里', '後龍鎮埔頂里中興路136-1號', '037-724839');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C005', '綠苗里', '苗栗市綠苗里中正路766號', '037-333240');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C006', '民族里', '民族里民族路96號', '037-660001');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C007', '忠孝里', '忠孝里光大街82號', '037-661145');
insert into STUDENT.COUNTRY_INFO ( 村里別代號, 村里別, 村里辦公室位置, 村里辦公室電話) values ('C008', '信義里', '信義里信義路53巷1號', '037-616072');
commit;
--4.1
select po.轄管分局, po.分局聯絡電話
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."轄管分局代碼" = po."轄管分局代碼" 
where off.容人數量>'1000' ; 

--4.2
select po.轄管分局, po.分局聯絡電話, COUNT(*) as 容人數量
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."轄管分局代碼" = po."轄管分局代碼" 
where off.容人數量>'1000' 
group by 轄管分局, 分局聯絡電話; 

--4.3
select po.轄管分局, po.分局聯絡電話, off.避難設施地址, off.類別, COUNT(*) as 容人數量
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."轄管分局代碼" = po."轄管分局代碼" 
where off.容人數量>1000 
group by 轄管分局, 分局聯絡電話, 避難設施地址, 類別; 

--4.4
select po.轄管分局, po.分局聯絡電話, off.避難設施地址, off.容人數量, cun."村里別" 
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."轄管分局代碼" = po."轄管分局代碼" 
full join STUDENT.COUNTRY_INFO cun on off."村里別代號" = cun."村里別代號"
where off.避難設施地址 LIKE '%中%';

--4.5
select cun."村里別", cun."村里辦公室位置", off."避難設施地址", off."容人數量" 
from STUDENT.OFFICE_INFO off 
full join STUDENT.COUNTRY_INFO cun on off."村里別代號" = cun."村里別代號"
where off.類別 in ('公寓', '大樓');

--5.1
update STUDENT.OFFICE_INFO set 容人數量 = '5000'  where 避難設施地址 = '苗栗縣竹南鎮和平街79號';

--5.2
delete from STUDENT.OFFICE_INFO where 容人數量 < 1000;

