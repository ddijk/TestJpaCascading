--select * from APP.PORTFOLIOTD;

drop table app.pf_td;
drop table app.pf;

create table APP.pf (id int not null primary key, DSC varchar(20));
create table APP.pf_td (pf_id int not null, startdate date not null, naam varchar(20));

alter table app.pf_td add  primary key(pf_id, startdate);

--alter table APP.pf add primary key(id);
alter table APP.pf_td add CONSTRAINT my_fk foreign key(pf_id)  references APP.pf(id) ON DELETE CASCADE;

--ALTER TABLE APP.PF_TD DROP FOREIGN KEY FK_PF_TD_PF_ID;

