-- ����
DROP TABLE IF EXISTS p2_lect RESTRICT;

-- ���ǽ�
DROP TABLE IF EXISTS p2_cls_room RESTRICT;

-- �л�
DROP TABLE IF EXISTS p2_stud RESTRICT;

-- ����
DROP TABLE IF EXISTS p2_tchr RESTRICT;

-- �Ŵ���
DROP TABLE IF EXISTS p2_mgr RESTRICT;

-- ���ǽǻ���
DROP TABLE IF EXISTS p2_cr_phot RESTRICT;

-- ����
DROP TABLE IF EXISTS p2_subj RESTRICT;

-- �������
DROP TABLE IF EXISTS p2_tchr_lect RESTRICT;

-- ���ǰ���
DROP TABLE IF EXISTS p2_tch_subj RESTRICT;

-- ȸ��
DROP TABLE IF EXISTS p2_memb RESTRICT;

-- ����
CREATE TABLE p2_lect (
	lno   INTEGER      NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	titl  VARCHAR(255) NOT NULL COMMENT '���Ǹ�', -- ���Ǹ�
	conts TEXT         NOT NULL COMMENT '����', -- ����
	sdt   DATE         NOT NULL COMMENT '������', -- ������
	edt   DATE         NOT NULL COMMENT '������', -- ������
	capa  INTEGER      NOT NULL COMMENT '�����ο�', -- �����ο�
	pric  INTEGER      NOT NULL COMMENT '������', -- ������
	supp  CHAR(1)      NOT NULL COMMENT '������������', -- ������������
	crno  INTEGER      NULL     COMMENT '���ǽǹ�ȣ', -- ���ǽǹ�ȣ
	mno   INTEGER      NULL     COMMENT '�Ŵ�����ȣ' -- �Ŵ�����ȣ
)
COMMENT '����';

-- ����
ALTER TABLE p2_lect
	ADD CONSTRAINT PK_p2_lect -- ���� �⺻Ű
		PRIMARY KEY (
			lno -- ���ǹ�ȣ
		);

-- ���� �ε���
CREATE INDEX IX_p2_lect
	ON p2_lect( -- ����
		titl ASC -- ���Ǹ�
	);

ALTER TABLE p2_lect
	MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- ���ǽ�
CREATE TABLE p2_cls_room (
	crno INTEGER     NOT NULL COMMENT '���ǽǹ�ȣ', -- ���ǽǹ�ȣ
	loc  VARCHAR(50) NULL     COMMENT '������', -- ������
	room VARCHAR(50) NULL     COMMENT '���ǽǸ�', -- ���ǽǸ�
	capa INTEGER     NULL     COMMENT '�ִ���밡���ο�' -- �ִ���밡���ο�
)
COMMENT '���ǽ�';

-- ���ǽ�
ALTER TABLE p2_cls_room
	ADD CONSTRAINT PK_p2_cls_room -- ���ǽ� �⺻Ű
		PRIMARY KEY (
			crno -- ���ǽǹ�ȣ
		);

-- ���ǽ� ����ũ �ε���
CREATE UNIQUE INDEX UIX_p2_cls_room
	ON p2_cls_room ( -- ���ǽ�
		loc ASC,  -- ������
		room ASC  -- ���ǽǸ�
	);

ALTER TABLE p2_cls_room
	MODIFY COLUMN crno INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǽǹ�ȣ';

-- �л�
CREATE TABLE p2_stud (
	sno   INTEGER      NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	work  CHAR(1)      NOT NULL COMMENT '��������', -- ��������
	birth DATE         NULL     COMMENT '�������', -- �������
	phot  VARCHAR(255) NULL     COMMENT '����' -- ����
)
COMMENT '�л�';

-- �л�
ALTER TABLE p2_stud
	ADD CONSTRAINT PK_p2_stud -- �л� �⺻Ű
		PRIMARY KEY (
			sno -- ȸ����ȣ
		);

-- ����
CREATE TABLE p2_tchr (
	tno   INTEGER      NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	photo VARCHAR(255) NOT NULL COMMENT '����', -- ����
	pay   INTEGER      NULL     COMMENT '���Ƿ�' -- ���Ƿ�
)
COMMENT '����';

-- ����
ALTER TABLE p2_tchr
	ADD CONSTRAINT PK_p2_tchr -- ���� �⺻Ű
		PRIMARY KEY (
			tno -- ȸ����ȣ
		);

-- �Ŵ���
CREATE TABLE p2_mgr (
	mno  INTEGER     NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	posi VARCHAR(50) NOT NULL COMMENT '����' -- ����
)
COMMENT '�Ŵ���';

-- �Ŵ���
ALTER TABLE p2_mgr
	ADD CONSTRAINT PK_p2_mgr -- �Ŵ��� �⺻Ű
		PRIMARY KEY (
			mno -- ȸ����ȣ
		);

-- ���ǽǻ���
CREATE TABLE p2_cr_phot (
	cpno INTEGER      NOT NULL COMMENT '���ǽǻ�����ȣ', -- ���ǽǻ�����ȣ
	phot VARCHAR(255) NULL     COMMENT '�������ϸ�', -- �������ϸ�
	crno INTEGER      NULL     COMMENT '���ǽǹ�ȣ' -- ���ǽǹ�ȣ
)
COMMENT '���ǽǻ���';

-- ���ǽǻ���
ALTER TABLE p2_cr_phot
	ADD CONSTRAINT PK_p2_cr_phot -- ���ǽǻ��� �⺻Ű
		PRIMARY KEY (
			cpno -- ���ǽǻ�����ȣ
		);

ALTER TABLE p2_cr_phot
	MODIFY COLUMN cpno INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǽǻ�����ȣ';

-- ����
CREATE TABLE p2_subj (
	sjno INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	titl VARCHAR(255) NOT NULL COMMENT '���ǰ���' -- ���ǰ���
)
COMMENT '����';

-- ����
ALTER TABLE p2_subj
	ADD CONSTRAINT PK_p2_subj -- ���� �⺻Ű
		PRIMARY KEY (
			sjno -- �����ȣ
		);

-- ���� ����ũ �ε���
CREATE UNIQUE INDEX UIX_p2_subj
	ON p2_subj ( -- ����
		titl ASC -- ���ǰ���
	);

ALTER TABLE p2_subj
	MODIFY COLUMN sjno INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

-- �������
CREATE TABLE p2_tchr_lect (
	lno INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	tno INTEGER NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '�������';

-- �������
ALTER TABLE p2_tchr_lect
	ADD CONSTRAINT PK_p2_tchr_lect -- ������� �⺻Ű
		PRIMARY KEY (
			lno, -- ���ǹ�ȣ
			tno  -- ȸ����ȣ
		);

-- ���ǰ���
CREATE TABLE p2_tch_subj (
	sjno INTEGER NOT NULL COMMENT '�����ȣ', -- �����ȣ
	tno  INTEGER NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '���ǰ���';

-- ���ǰ���
ALTER TABLE p2_tch_subj
	ADD CONSTRAINT PK_p2_tch_subj -- ���ǰ��� �⺻Ű
		PRIMARY KEY (
			sjno, -- �����ȣ
			tno   -- ȸ����ȣ
		);

-- ȸ��
CREATE TABLE p2_memb (
	uno      INTEGER      NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	name     VARCHAR(50)  NOT NULL COMMENT '�̸�', -- �̸�
	tel      VARCHAR(30)  NOT NULL COMMENT '��ȭ', -- ��ȭ
	email    VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	edu      VARCHAR(50)  NOT NULL COMMENT '�����з�', -- �����з�
	schl     VARCHAR(50)  NULL     COMMENT '�����б���', -- �����б���
	maj      VARCHAR(50)  NULL     COMMENT '����', -- ����
	pstno    VARCHAR(10)  NOT NULL COMMENT '�����ȣ', -- �����ȣ
	bas_addr VARCHAR(255) NOT NULL COMMENT '�⺻�ּ�', -- �⺻�ּ�
	det_addr VARCHAR(255) NULL     COMMENT '���ּ�' -- ���ּ�
)
COMMENT 'ȸ��';

-- ȸ��
ALTER TABLE p2_memb
	ADD CONSTRAINT PK_p2_memb -- ȸ�� �⺻Ű
		PRIMARY KEY (
			uno -- ȸ����ȣ
		);

-- ȸ�� ����ũ �ε���
CREATE UNIQUE INDEX UIX_p2_memb
	ON p2_memb ( -- ȸ��
		email ASC -- �̸���
	);

-- ȸ�� �ε���
CREATE INDEX IX_p2_memb
	ON p2_memb( -- ȸ��
		name ASC -- �̸�
	);

-- ȸ�� �ε���2
CREATE INDEX IX_p2_memb2
	ON p2_memb( -- ȸ��
		tel ASC -- ��ȭ
	);

ALTER TABLE p2_memb
	MODIFY COLUMN uno INTEGER NOT NULL AUTO_INCREMENT COMMENT 'ȸ����ȣ';

-- ����
ALTER TABLE p2_lect
	ADD CONSTRAINT FK_p2_mgr_TO_p2_lect -- �Ŵ��� -> ����
		FOREIGN KEY (
			mno -- �Ŵ�����ȣ
		)
		REFERENCES p2_mgr ( -- �Ŵ���
			mno -- ȸ����ȣ
		);

-- ����
ALTER TABLE p2_lect
	ADD CONSTRAINT FK_p2_cls_room_TO_p2_lect -- ���ǽ� -> ����
		FOREIGN KEY (
			crno -- ���ǽǹ�ȣ
		)
		REFERENCES p2_cls_room ( -- ���ǽ�
			crno -- ���ǽǹ�ȣ
		);

-- �л�
ALTER TABLE p2_stud
	ADD CONSTRAINT FK_p2_memb_TO_p2_stud -- ȸ�� -> �л�
		FOREIGN KEY (
			sno -- ȸ����ȣ
		)
		REFERENCES p2_memb ( -- ȸ��
			uno -- ȸ����ȣ
		);

-- ����
ALTER TABLE p2_tchr
	ADD CONSTRAINT FK_p2_memb_TO_p2_tchr -- ȸ�� -> ����
		FOREIGN KEY (
			tno -- ȸ����ȣ
		)
		REFERENCES p2_memb ( -- ȸ��
			uno -- ȸ����ȣ
		);

-- �Ŵ���
ALTER TABLE p2_mgr
	ADD CONSTRAINT FK_p2_memb_TO_p2_mgr -- ȸ�� -> �Ŵ���
		FOREIGN KEY (
			mno -- ȸ����ȣ
		)
		REFERENCES p2_memb ( -- ȸ��
			uno -- ȸ����ȣ
		);

-- ���ǽǻ���
ALTER TABLE p2_cr_phot
	ADD CONSTRAINT FK_p2_cls_room_TO_p2_cr_phot -- ���ǽ� -> ���ǽǻ���
		FOREIGN KEY (
			crno -- ���ǽǹ�ȣ
		)
		REFERENCES p2_cls_room ( -- ���ǽ�
			crno -- ���ǽǹ�ȣ
		);

-- �������
ALTER TABLE p2_tchr_lect
	ADD CONSTRAINT FK_p2_tchr_TO_p2_tchr_lect -- ���� -> �������
		FOREIGN KEY (
			tno -- ȸ����ȣ
		)
		REFERENCES p2_tchr ( -- ����
			tno -- ȸ����ȣ
		);

-- �������
ALTER TABLE p2_tchr_lect
	ADD CONSTRAINT FK_p2_lect_TO_p2_tchr_lect -- ���� -> �������
		FOREIGN KEY (
			lno -- ���ǹ�ȣ
		)
		REFERENCES p2_lect ( -- ����
			lno -- ���ǹ�ȣ
		);

-- ���ǰ���
ALTER TABLE p2_tch_subj
	ADD CONSTRAINT FK_p2_tchr_TO_p2_tch_subj -- ���� -> ���ǰ���
		FOREIGN KEY (
			tno -- ȸ����ȣ
		)
		REFERENCES p2_tchr ( -- ����
			tno -- ȸ����ȣ
		);

-- ���ǰ���
ALTER TABLE p2_tch_subj
	ADD CONSTRAINT FK_p2_subj_TO_p2_tch_subj -- ���� -> ���ǰ���
		FOREIGN KEY (
			sjno -- �����ȣ
		)
		REFERENCES p2_subj ( -- ����
			sjno -- �����ȣ
		);