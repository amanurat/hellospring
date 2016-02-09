
    alter table USERS 
        drop 
        foreign key FK_f9bpsl42v6015u3qx1ipw8dyc;

    alter table contact_hobby_detail 
        drop 
        foreign key FK_kcwr9imc2f5c6wpul4rkv03h9;

    alter table contact_hobby_detail 
        drop 
        foreign key FK_17guvveygbsxs4foucxxb9wl;

    alter table contact_tel_detail 
        drop 
        foreign key FK_9m78pab6h4i6oo4fkx9m1wp7r;

    drop table if exists USERS;

    drop table if exists USER_ROLES;

    drop table if exists contact;

    drop table if exists contact_hobby_detail;

    drop table if exists contact_tel_detail;

    drop table if exists hobby;

    create table USERS (
        ID integer not null auto_increment,
        BIRTHDAY datetime,
        GENDER varchar(255),
        PASSWORD varchar(255) not null,
        USERNAME varchar(10) not null,
        USER_ROLE integer,
        primary key (ID)
    );

    create table USER_ROLES (
        ID integer not null auto_increment,
        ROLE varchar(255),
        primary key (ID)
    );

    create table contact (
        ID bigint not null auto_increment,
        BIRTH_DATE date,
        FIRST_NAME varchar(255),
        LAST_NAME varchar(255),
        VERSION integer,
        primary key (ID)
    );

    create table contact_hobby_detail (
        CONTACT_ID bigint not null,
        HOBBY_ID varchar(255) not null,
        primary key (CONTACT_ID, HOBBY_ID)
    );

    create table contact_tel_detail (
        id bigint not null auto_increment,
        tel_number varchar(255),
        tel_type varchar(255),
        version integer,
        contact_id bigint,
        primary key (id)
    );

    create table hobby (
        hobby_id varchar(255) not null,
        primary key (hobby_id)
    );

    alter table USERS 
        add constraint FK_f9bpsl42v6015u3qx1ipw8dyc 
        foreign key (USER_ROLE) 
        references USER_ROLES (ID);

    alter table contact_hobby_detail 
        add constraint FK_kcwr9imc2f5c6wpul4rkv03h9 
        foreign key (HOBBY_ID) 
        references hobby (hobby_id);

    alter table contact_hobby_detail 
        add constraint FK_17guvveygbsxs4foucxxb9wl 
        foreign key (CONTACT_ID) 
        references contact (ID);

    alter table contact_tel_detail 
        add constraint FK_9m78pab6h4i6oo4fkx9m1wp7r 
        foreign key (contact_id) 
        references contact (ID);
