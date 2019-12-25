create table if not exists t_absence_setting
(
    id          varchar(36)                   not null comment 'id',
    absent_type varchar(20)                   not null comment '缺勤类型',
    proportion  double                        not null comment '扣除比例',
    should_days double                        not null comment '应到天数',
    status      varchar(20) default 'disable' null comment '启用状态',
    constraint `PRIMARY`
        primary key (id)
)
    comment '缺勤扣款规则表';

create table if not exists t_department
(
    department_id   varchar(20) not null comment '部门编号',
    department_name varchar(20) not null comment '部门名称',
    constraint `PRIMARY`
        primary key (department_id)
)
    comment '部门信息表';

create table if not exists t_duty
(
    duty_id     varchar(20) not null comment '职务编号',
    duty_name   varchar(20) not null comment '职务名称',
    duty_salary float       not null comment '职务工资',
    constraint `PRIMARY`
        primary key (duty_id)
)
    comment '职务信息表';

create table if not exists t_insurance_setting
(
    id           varchar(36)                   not null comment 'id',
    base_rate    double                        not null comment '缴纳基数比例',
    medical_rate double      default '0'       null comment '医疗保险扣除比例',
    aged_rate    double      default '0'       null comment '养老保险扣除比例',
    unemp_rate   double      default '0'       null comment '失业保险扣除比例',
    accu_rate    double      default '0'       null comment '公积金扣除比例',
    status       varchar(20) default 'disable' null comment '启用状态',
    constraint `PRIMARY`
        primary key (id)
)
    comment '五险一金扣款规则表';

create table if not exists t_role
(
    role_id   varchar(20) not null comment '角色编号',
    role_name varchar(20) not null comment '角色名称',
    constraint `PRIMARY`
        primary key (role_id)
)
    comment '角色表';

create table if not exists t_tax_setting
(
    id        varchar(36)                   not null comment 'id',
    min_num   double                        not null comment '上界',
    max_num   double                        not null comment '下界',
    rate      double                        not null comment '适用税率',
    calcu_num double                        not null comment '速算扣除数',
    status    varchar(20) default 'disable' null comment '启用状态',
    constraint `PRIMARY`
        primary key (id)
)
    comment '扣税规则表';

create table if not exists t_title
(
    title_id         varchar(20) not null comment '职称编号',
    title_name       varchar(20) not null comment '职称名称',
    title_salary     float       not null comment '职称工资',
    title_basesalary float       not null comment '基本工资',
    constraint `PRIMARY`
        primary key (title_id)
)
    comment '职称信息表';

create table if not exists t_staff_info
(
    staff_id           varchar(20)                      not null comment '员工编号',
    staff_pass_word    varchar(20)     default '000000' not null comment '登录密码',
    staff_name         varchar(20)                      not null comment '员工姓名',
    staff_sex          enum ('男', '女') default '女'      null comment '员工性别',
    staff_identity_num varchar(20)                      not null comment '身份证号',
    department_id      varchar(20)                      not null comment '所属部门编号',
    title_id           varchar(20)                      not null comment '职称编号',
    duty_id            varchar(20)                      not null comment '职务编号',
    staff_entry_time   date                             not null comment '入职时间',
    staff_bank_acount  varchar(20)                      not null comment '银行卡账号',
    staff_tel          varchar(20)                      not null comment '电话号码&登录账号',
    role_id            varchar(20)                      not null comment '角色编号',
    constraint `PRIMARY`
        primary key (staff_id),
    constraint staff_bank_acount
        unique (staff_bank_acount),
    constraint staff_identity_num
        unique (staff_identity_num),
    constraint staff_tel
        unique (staff_tel),
    constraint t_staff_info_ibfk_1
        foreign key (department_id) references t_department (department_id),
    constraint t_staff_info_ibfk_2
        foreign key (title_id) references t_title (title_id),
    constraint t_staff_info_ibfk_3
        foreign key (duty_id) references t_duty (duty_id),
    constraint t_staff_info_ibfk_4
        foreign key (role_id) references t_role (role_id)
)
    comment '员工信息表';

create table if not exists t_absent_info
(
    staff_id          varchar(20)                                       not null comment '员工编号',
    absent_reason     varchar(20)                                       null comment '缺勤原因',
    absent_apply_time date                                              not null comment '申请时间',
    absent_start_time date                                              not null comment '开始时间',
    absent_end_time   date                                              not null comment '结束时间',
    absent_days       tinyint                                           not null comment '请假天数',
    absent_check_time date                                              not null comment '审核时间',
    absent_state      enum ('std', 'd_pass', 'd_reject', 'dtp', 'done') not null comment '审核状态',
    absent_money      double default '0'                                null comment '缺勤金',
    absent_detail     varchar(225)                                      null,
    constraint `PRIMARY`
        primary key (staff_id, absent_start_time),
    constraint t_absent_info_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id)
)
    comment '考勤信息表';

create table if not exists t_absent_money
(
    staff_id           varchar(20)         not null comment '员工编号',
    due_days           int(2) default '22' null comment '应到天数',
    actual_days        int(2) default '22' null comment '实到天数',
    money              float  default '0'  null comment '缺勤金',
    check_time         date                not null comment '考核年月',
    absent_money_state varchar(36)         null,
    constraint `PRIMARY`
        primary key (staff_id, check_time),
    constraint t_absent_money_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id)
)
    comment '考勤扣款表';

create table if not exists t_insurance
(
    staff_id          varchar(20)       not null comment '员工编号',
    insurance_medical float default '0' null comment '医疗保险',
    insurance_aged    float default '0' null comment '养老保险',
    insurance_unemp   float default '0' null comment '失业保险',
    insurance_accu    float default '0' null comment '公积金',
    insurance_time    date              not null comment '考核年月',
    insurance_state   varchar(36)       null,
    insurance_base    float default '0' not null,
    insurance_total   float default '0' not null,
    constraint `PRIMARY`
        primary key (staff_id, insurance_time),
    constraint t_insurance_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id)
)
    comment '五险一金表';

create table if not exists t_prize
(
    staff_id         varchar(20)                        not null comment '员工编号',
    prize_long_pay   float default '0'                  null comment '工龄津贴',
    prize_welfare    float default '500'                null comment '福利补贴',
    prize_full_bonus float default '200'                null comment '全勤奖',
    check_time       date                               not null comment '考核年月',
    prize_state      enum ('ptf', 'f_pass', 'f_reject') not null comment '审核状态',
    constraint `PRIMARY`
        primary key (staff_id, check_time),
    constraint t_prize_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id)
)
    comment '绩效奖金表';

create index department_id
    on t_staff_info (department_id);

create index duty_id
    on t_staff_info (duty_id);

create index role_id
    on t_staff_info (role_id);

create index title_id
    on t_staff_info (title_id);

create table if not exists t_tax
(
    staff_id      varchar(20) not null comment '员工编号',
    tax_taxable   float       null comment '应纳税所得额',
    tax_rate      float       null comment '适用税率',
    tax_calcu     float       null comment '速算扣除数',
    tax_tax_money float       null comment '纳税金额',
    check_time    date        not null comment '审核时间',
    tax_state     varchar(36) null,
    constraint `PRIMARY`
        primary key (staff_id, check_time),
    constraint t_tax_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id)
)
    comment '纳税款表';

create table if not exists t_to_bank
(
    staff_id           varchar(20) not null comment '员工编号',
    staff_name         varchar(20) not null comment '员工姓名',
    staff_identity_num varchar(20) not null comment '身份证号',
    staff_bank_acount  varchar(20) not null comment '银行卡账号',
    staff_tel          varchar(20) not null comment '电话号码&登录账号',
    salary             float       null comment '应发金额',
    send_time          date        not null comment '发放时间',
    constraint `PRIMARY`
        primary key (staff_id, send_time),
    constraint staff_tel
        unique (staff_tel),
    constraint t_to_bank_ibfk_1
        foreign key (staff_id) references t_staff_info (staff_id),
    constraint t_to_bank_ibfk_2
        foreign key (staff_tel) references t_staff_info (staff_tel),
    constraint t_to_bank_ibfk_3
        foreign key (staff_identity_num) references t_staff_info (staff_identity_num),
    constraint t_to_bank_ibfk_4
        foreign key (staff_bank_acount) references t_staff_info (staff_bank_acount)
)
    comment '银行发放表';

create index staff_bank_acount
    on t_to_bank (staff_bank_acount);

create index staff_identity_num
    on t_to_bank (staff_identity_num);

create view v_staff_info as -- missing source code
;

-- comment on view v_staff_info not supported: VIEW

-- comment on column v_staff_info.staff_id not supported: 员工编号

-- comment on column v_staff_info.staff_name not supported: 员工姓名

-- comment on column v_staff_info.staff_sex not supported: 员工性别

-- comment on column v_staff_info.department_name not supported: 部门名称

-- comment on column v_staff_info.staff_tel not supported: 电话号码&登录账号

-- comment on column v_staff_info.staff_identity_num not supported: 身份证号

-- comment on column v_staff_info.title_name not supported: 职称名称

-- comment on column v_staff_info.duty_name not supported: 职务名称

-- comment on column v_staff_info.staff_bank_acount not supported: 银行卡账号

-- comment on column v_staff_info.staff_entry_time not supported: 入职时间

-- comment on column v_staff_info.role_name not supported: 角色名称

-- comment on column v_staff_info.duty_salary not supported: 职务工资

-- comment on column v_staff_info.title_salary not supported: 职称工资

-- comment on column v_staff_info.title_basesalary not supported: 基本工资


