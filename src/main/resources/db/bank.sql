alter table Account
    drop constraint FK_ACCOUNT_RELATIONS_RESTRICT;

alter table Account
    drop constraint FK_ACCOUNT_RELATIONS_PERSON;

alter table Amount
    drop constraint FK_AMOUNT_RELATIONS_DEPOSIT;

alter table Amount
    drop constraint FK_AMOUNT_RELATIONS_ACCOUNT;

alter table Bank
    drop constraint FK_BANK_RELATIONS_DEPOSIT;

alter table Bank
    drop constraint FK_BANK_RELATIONS_ACCOUNT;

alter table City
    drop constraint FK_CITY_RELATIONS_BANK;

alter table Deposit
    drop constraint FK_DEPOSIT_RELATIONS_BONUS;

alter table Deposit
    drop constraint FK_DEPOSIT_RELATIONS_RESTRICT;

alter table Deposit
    drop constraint FK_DEPOSIT_RELATIONS_PLAN;

alter table Deposit
    drop constraint FK_DEPOSIT_RELATIONS_PERSON;

alter table Type
    drop constraint FK_TYPE_RELATIONS_BANK;

alter table Type
    drop constraint FK_TYPE_RELATIONS_DEPOSIT;

drop table Account;

drop table Amount;

drop table Bank;

drop table Bonus;

drop table City;

drop table Deposit;

drop table Person;

drop table Plan;

drop table Restriction;

drop table Type;

/*==============================================================*/
/* Table: Account                                               */
/*==============================================================*/
create table Account
(
    Res_id               BIGINT,
    created              DATE,
    active               INTEGER,
    id                   BIGINT            not null,
    constraint PK_ACCOUNT primary key (id)
);

/*==============================================================*/
/* Table: Amount                                                */
/*==============================================================*/
create table Amount
(
    id                   BIGINT            not null,
    Acc_id               BIGINT,
    name                 text,
    active               INTEGER,
    debt                 BIGINT,
    balance              BIGINT,
    constraint PK_AMOUNT primary key (id)
);

/*==============================================================*/
/* Table: Bank                                                  */
/*==============================================================*/
create table Bank
(
    id                   BIGINT            not null,
    Acc_id               BIGINT,
    name                 text,
    created              DATE,
    active               INTEGER,
    constraint PK_BANK primary key (id)
);

/*==============================================================*/
/* Table: Bonus                                                 */
/*==============================================================*/
create table Bonus
(
    created              DATE,
    year                 INTEGER,
    active               INTEGER,
    id                   BIGINT            not null,
    constraint PK_BONUS primary key (id)
);

/*==============================================================*/
/* Table: City                                                  */
/*==============================================================*/
create table City
(
    id                   BIGINT            not null,
    name                 text,
    year                 text,
    constraint PK_CITY primary key (id)
);

/*==============================================================*/
/* Table: Deposit                                               */
/*==============================================================*/
create table Deposit
(
    name                 text,
    currency             text,
    year                 INTEGER,
    "to"                 DATE,
    "from"               DATE,
    Pla_id               BIGINT,
    Res_id               BIGINT,
    Bon_id               BIGINT,
    id                   BIGINT            not null,
    constraint PK_DEPOSIT primary key (id)
);

/*==============================================================*/
/* Table: Person                                                */
/*==============================================================*/
create table Person
(
    name                 text,
    surname              text,
    born                 DATE,
    place                text,
    active               INTEGER,
    id                   BIGINT            not null,
    constraint PK_PERSON primary key (id)
);

/*==============================================================*/
/* Table: Plan                                                  */
/*==============================================================*/
create table Plan
(
    created              DATE,
    year                 INTEGER,
    active               INTEGER,
    id                   BIGINT            not null,
    constraint PK_PLAN primary key (id)
);

/*==============================================================*/
/* Table: Restriction                                           */
/*==============================================================*/
create table Restriction
(
    year                 INTEGER,
    created              DATE,
    id                   BIGINT            not null,
    constraint PK_RESTRICTION primary key (id)
);

/*==============================================================*/
/* Table: Type                                                  */
/*==============================================================*/
create table Type
(
    id                   BIGINT            not null,
    Dep_id               BIGINT,
    name                 text,
    year                 INTEGER,
    created              DATE,
    constraint PK_TYPE primary key (id)
);

alter table Account
    add constraint FK_ACCOUNT_RELATIONS_RESTRICT foreign key (Res_id)
        references Restriction (id);

alter table Account
    add constraint FK_ACCOUNT_RELATIONS_PERSON foreign key (id)
        references Person (id);

alter table Amount
    add constraint FK_AMOUNT_RELATIONS_DEPOSIT foreign key (id)
        references Deposit (id);

alter table Amount
    add constraint FK_AMOUNT_RELATIONS_ACCOUNT foreign key (Acc_id)
        references Account (id);

alter table Bank
    add constraint FK_BANK_RELATIONS_DEPOSIT foreign key (id)
        references Deposit (id);

alter table Bank
    add constraint FK_BANK_RELATIONS_ACCOUNT foreign key (Acc_id)
        references Account (id);

alter table City
    add constraint FK_CITY_RELATIONS_BANK foreign key (id)
        references Bank (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_BONUS foreign key (Bon_id)
        references Bonus (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_RESTRICT foreign key (Res_id)
        references Restriction (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_PLAN foreign key (Pla_id)
        references Plan (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_PERSON foreign key (id)
        references Person (id);

alter table Type
    add constraint FK_TYPE_RELATIONS_BANK foreign key (id)
        references Bank (id);

alter table Type
    add constraint FK_TYPE_RELATIONS_DEPOSIT foreign key (Dep_id)
        references Deposit (id);
