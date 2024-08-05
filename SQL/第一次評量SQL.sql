--��@�m��2
create table OFFICE (
    �Һޤ����N�X VARCHAR2(20),
    �����a�} NVARCHAR2(100),
    �����p���q�� VARCHAR2(20),
    �Һޤ��� NVARCHAR2(100));

create table OFFICE_INFO (
    ���O VARCHAR2(20),
    �����]�I�a�} NVARCHAR2(100),
    �e�H�ƶq NUMBER(13,0),
    �a�U�Ӽh��  NUMBER(8,0),
    �Һޤ����N�X VARCHAR2(20),
    �����O�N�� VARCHAR2(20));
    
create table COUNTRY_INFO (
    �����O�N�� VARCHAR2(20),
    �����O NVARCHAR2(100),
    �����줽�Ǧ�m NVARCHAR2(100),
    �����줽�ǹq�� VARCHAR2(20));

alter table STUDENT.OFFICE add primary key (OFFICE_CODE);
commit;
alter table STUDENT.EVACUATION_FACILITY add primary key (RUNNING_NUMBER);
commit;
alter table STUDENT.COUNTRY_INFO add primary key (COUNTRY_CODE);
commit;

--��@�m��3
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M001', '�]�߿��˫n����ڵ�72��', '03 747 4796', '�˫n����');
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M002', '�]�߿��]�ߥ������109��', '03 732 0059', '�]�ߤ���');
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M003', '�]�߿��Y����������503��', '03 766 3004', '�Y������');
commit;
alter table STUDENT.OFFICE rename column �Һޤ����N�X to OFFICE_CODE;
alter table STUDENT.OFFICE rename column �����a�} to OFFICE_ADD;
alter table STUDENT.OFFICE rename column �����p���q�� to OFFICE_TEL;
alter table STUDENT.OFFICE rename column �Һޤ��� to OFFICE_NM;
commit;

insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��˫n���H��20��', '100', '1',  'M001', 'C001');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��˫n��M����79��', '3142', '1',  'M001', 'C002');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��˫n���s�s���T�q142��', '1072', '1',  'M001', 'C003');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���@�]�I', '�]�߿����s���ظ�1498��', '32', '1',  'M001', 'C004');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��]�ߥ��̥���80��', '106', '1',  'M002', 'C005');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��]�ߥ����_��117��', '26', '1',  'M002', 'C005');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��]�ߥ��շR��109��', '2038', '2',  'M002', 'C005');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��]�ߥ��j�P��53��', '128', '2',  'M002', 'C005');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���@�]�I', '�]�߿��Y�������ڨ��M����102��', '353', '1',  'M003', 'C006');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�p����', '�]�߿��Y�������������@��69��', '501', '1',  'M003', 'C007');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��Y�����H�q��������65��', '194', '1',  'M003', 'C008');
insert into STUDENT.EVACUATION_FACILITY ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�p����', '�]�߿��Y�����H�q��������116��', '78', '1',  'M003', 'C008');
commit;
alter table STUDENT.EVACUATION_FACILITY rename column ���O to CLASS;
alter table STUDENT.EVACUATION_FACILITY rename column �����]�I�a�} to FACILITY_ADD;
alter table STUDENT.EVACUATION_FACILITY rename column �e�H�ƶq to PEOPLE;
alter table STUDENT.EVACUATION_FACILITY rename column �a�U�Ӽh�� to BASEMNET;
alter table STUDENT.EVACUATION_FACILITY rename column �Һޤ����N�X to OFFICE_CODE;
alter table STUDENT.EVACUATION_FACILITY rename column �����O�N�� to COUNTRY_CODE;
commit;

insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C001', '�j�H��', '�˫n���q��1035��', '03 758 1072');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C002', '�˫n��', '�˫n��˫n�����s��103��', '037-472735');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C003', '�s�Ψ�', '�˫n��s�Ψ������14��', '037-614186');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C004', '���H��', '���s��H����������136-1��', '037-724839');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C005', '��]��', '�]�ߥ���]��������766��', '037-333240');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C006', '���ڨ�', '���ڨ����ڸ�96��', '037-660001');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C007', '������', '���������j��82��', '037-661145');
insert into STUDENT.COUNTRY_INFO ( �����O�N��, �����O, �����줽�Ǧ�m, �����줽�ǹq��) values ('C008', '�H�q��', '�H�q���H�q��53��1��', '037-616072');
commit;
alter table STUDENT.COUNTRY_INFO rename column �����O�N�� to COUNTRY_CODE;
alter table STUDENT.COUNTRY_INFO rename column �����O to COUNTRY_NM;
alter table STUDENT.COUNTRY_INFO rename column �����줽�Ǧ�m to COUNTRY_ADD;
alter table STUDENT.COUNTRY_INFO rename column �����줽�ǹq�� to COUNTRY_TEL;
commit;
alter table STUDENT.EVACUATION_FACILITY add RUNNING_NUMBER NUMBER(13,0);
commit;
update STUDENT.EVACUATION_FACILITY set RUNNING_NUMBER = 13 where PEOPLE = 3142;
--4.1
select distinct OFF.OFFICE_NM as �Һޤ���, OFF.OFFICE_TEL as �����p���q��
 from STUDENT.EVACUATION_FACILITY EF
 left join STUDENT.OFFICE OFF on OFF.OFFICE_CODE = EF.OFFICE_CODE
 where EF.PEOPLE>1000 ; 

--4.2
select distinct OFF.OFFICE_NM as �Һޤ���, OFF.OFFICE_TEL as �����p���q��, COUNT(*) over (partition by OFFICE_NM) as �e�H�ƶq
 from STUDENT.EVACUATION_FACILITY EF 
 left join STUDENT.OFFICE OFF  on OFF.OFFICE_CODE = EF.OFFICE_CODE 
 where EF.PEOPLE>1000; 

--4.3
select distinct OFF.OFFICE_NM as �Һޤ���, OFF.OFFICE_TEL as �����p���q��, EF.FACILITY_ADD as �����]�I�a�}, EF.CLASS as ���O, COUNT(*) over (partition by OFFICE_NM) as �e�H�ƶq
 from STUDENT.EVACUATION_FACILITY EF 
 left join STUDENT.OFFICE OFF  on OFF.OFFICE_CODE = EF.OFFICE_CODE 
 where EF.PEOPLE>1000; 
 

--4.4
select OFF.OFFICE_NM as �Һޤ���, OFF.OFFICE_TEL as �����p���q��, EF.FACILITY_ADD as �����]�I�a�}, EF.CLASS as ���O, CUN.COUNTRY_NM as �����O
 from STUDENT.OFFICE OFF  
 left join STUDENT.EVACUATION_FACILITY EF on OFF.OFFICE_CODE = EF.OFFICE_CODE
 left join STUDENT.COUNTRY_INFO CUN on EF.COUNTRY_CODE = CUN.COUNTRY_CODE
 where EF.FACILITY_ADD LIKE '%��%';

--4.5
select  CUN.COUNTRY_NM as �����O, CUN.COUNTRY_ADD as �����줽�Ǧ�m, EF.PEOPLE as �e�H�ƶq, EF.FACILITY_ADD as �����]�I�a�}
 from STUDENT.EVACUATION_FACILITY EF
 full join STUDENT.COUNTRY_INFO CUN on EF.COUNTRY_CODE = CUN.COUNTRY_CODE
 where OFF.class in ('���J', '�j��');

--5.1
update STUDENT.EVACUATION_FACILITY set PEOPLE = 5000  where FACILITY_ADD = '�]�߿��˫n��M����79��';

--5.2
delete from STUDENT.EVACUATION_FACILITY where PEOPLE < 1000;

