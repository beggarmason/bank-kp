create table Account
(
    restriction          BIGINT,
    person               BIGINT,
    created              DATE,
    active               boolean,
    id                   BIGINT            not null,
    constraint PK_ACCOUNT primary key (id)
);

/*==============================================================*/
/* Table: Amount                                                */
/*==============================================================*/
create table Amount
(
    id                   BIGINT            not null,
    account              BIGINT,
    deposit              BIGINT,
    name                 text,
    active               boolean,
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
    account              BIGINT,
    deposit              BIGINT,
    type                 BIGINT,
    name                 text,
    created              DATE,
    active               boolean,
    constraint PK_BANK primary key (id)
);

/*==============================================================*/
/* Table: Bonus                                                 */
/*==============================================================*/
create table Bonus
(
    created              DATE,
    year                 INTEGER,
    active               boolean,
    id                   BIGINT            not null,
    constraint PK_BONUS primary key(id)
);

/*==============================================================*/
/* Table: City                                                  */
/*==============================================================*/
create table City
(
    id                   BIGINT            not null,
    bank                 BIGINT,
    name                 text,
    year                 INTEGER,
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
    toDate                 DATE,
    fromDate               DATE,
    plan                 BIGINT,
    restriction          BIGINT,
    bonus                BIGINT,
    person               BIGINT,
    type                 BIGINT,
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
    active               boolean,
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
    active               boolean,
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
    name                 text,
    year                 INTEGER,
    created              DATE,
    constraint PK_TYPE primary key (id)
);

alter table Account
    add constraint FK_ACCOUNT_RELATIONS_RESTRICT foreign key (restriction)
        references Restriction (id);

alter table Account
    add constraint FK_ACCOUNT_RELATIONS_PERSON foreign key (person)
        references Person (id);

alter table Amount
    add constraint FK_AMOUNT_RELATIONS_DEPOSIT foreign key (deposit)
        references Deposit (id);

alter table Amount
    add constraint FK_AMOUNT_RELATIONS_ACCOUNT foreign key (account)
        references Account (id);

alter table Bank
    add constraint FK_BANK_RELATIONS_DEPOSIT foreign key (deposit)
        references Deposit (id);

alter table Bank
    add constraint FK_BANK_RELATIONS_ACCOUNT foreign key (account)
        references Account (id);

alter table Bank
    add constraint FK_BANK_RELATIONS_TYPE foreign key (type)
        references Type (id);

alter table City
    add constraint FK_CITY_RELATIONS_BANK foreign key (bank)
        references Bank (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_BONUS foreign key (bonus)
        references Bonus (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_RESTRICT foreign key (restriction)
        references Restriction (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_PLAN foreign key (plan)
        references Plan (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_PERSON foreign key (person)
        references Person (id);

alter table Deposit
    add constraint FK_DEPOSIT_RELATIONS_TYPE foreign key (type)
        references Type (id);