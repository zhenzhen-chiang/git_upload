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
    
--��@�m��3
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M001', '�]�߿��˫n����ڵ�72��', '03 747 4796', '�˫n����');
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M002', '�]�߿��]�ߥ������109��', '03 732 0059', '�]�ߤ���');
insert into STUDENT.OFFICE ( �Һޤ����N�X, �����a�}, �����p���q��, �Һޤ���) values ('M003', '�]�߿��Y����������503��', '03 766 3004', '�Y������');
commit;

insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��˫n���H��20��', '100', '1',  'MOO1', 'C001');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��˫n��M����79��', '3142', '1',  'MOO1', 'C002');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��˫n���s�s���T�q142��', '1072', '1',  'MOO1', 'C003');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���@�]�I', '�]�߿����s���ظ�1498��', '32', '1',  'MOO1', 'C004');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��]�ߥ��̥���80��', '106', '1',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��]�ߥ����_��117��', '26', '1',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��]�ߥ��շR��109��', '2038', '2',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�j��', '�]�߿��]�ߥ��j�P��53��', '128', '2',  'MOO2', 'C005');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���@�]�I', '�]�߿��Y�������ڨ��M����102��', '353', '1',  'MOO3', 'C006');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�p����', '�]�߿��Y�������������@��69��', '501', '1',  'MOO3', 'C007');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('���J', '�]�߿��Y�����H�q��������65��', '194', '1',  'MOO3', 'C008');
insert into STUDENT.OFFICE_INFO ( ���O, �����]�I�a�}, �e�H�ƶq, �a�U�Ӽh��, �Һޤ����N�X, �����O�N��) values ('�p����', '�]�߿��Y�����H�q��������116��', '78', '1',  'MOO3', 'C008');
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
--4.1
select po.�Һޤ���, po.�����p���q��
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."�Һޤ����N�X" = po."�Һޤ����N�X" 
where off.�e�H�ƶq>'1000' ; 

--4.2
select po.�Һޤ���, po.�����p���q��, COUNT(*) as �e�H�ƶq
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."�Һޤ����N�X" = po."�Һޤ����N�X" 
where off.�e�H�ƶq>'1000' 
group by �Һޤ���, �����p���q��; 

--4.3
select po.�Һޤ���, po.�����p���q��, off.�����]�I�a�}, off.���O, COUNT(*) as �e�H�ƶq
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."�Һޤ����N�X" = po."�Һޤ����N�X" 
where off.�e�H�ƶq>1000 
group by �Һޤ���, �����p���q��, �����]�I�a�}, ���O; 

--4.4
select po.�Һޤ���, po.�����p���q��, off.�����]�I�a�}, off.�e�H�ƶq, cun."�����O" 
from STUDENT.OFFICE po 
full join STUDENT.OFFICE_INFO off on off."�Һޤ����N�X" = po."�Һޤ����N�X" 
full join STUDENT.COUNTRY_INFO cun on off."�����O�N��" = cun."�����O�N��"
where off.�����]�I�a�} LIKE '%��%';

--4.5
select cun."�����O", cun."�����줽�Ǧ�m", off."�����]�I�a�}", off."�e�H�ƶq" 
from STUDENT.OFFICE_INFO off 
full join STUDENT.COUNTRY_INFO cun on off."�����O�N��" = cun."�����O�N��"
where off.���O in ('���J', '�j��');

--5.1
update STUDENT.OFFICE_INFO set �e�H�ƶq = '5000'  where �����]�I�a�} = '�]�߿��˫n��M����79��';

--5.2
delete from STUDENT.OFFICE_INFO where �e�H�ƶq < 1000;

