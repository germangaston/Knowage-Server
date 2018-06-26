--- START ---
ALTER TABLE SBI_I18N_MESSAGES RENAME TO SBI_I18N_MESSAGES_OLD;

CREATE TABLE SBI_I18N_MESSAGES AS 
SELECT ROW_NUMBER() OVER() AS ID, T.*
FROM SBI_I18N_MESSAGES_OLD T;

DROP TABLE SBI_I18N_MESSAGES_OLD;

ALTER TABLE SBI_I18N_MESSAGES ADD CONSTRAINT PK_SBI_I18N_MESSAGES PRIMARY KEY (ID);
ALTER TABLE SBI_I18N_MESSAGES ADD CONSTRAINT FK_SBI_I18N_MESSAGES FOREIGN KEY (LANGUAGE_CD) REFERENCES SBI_DOMAINS (VALUE_ID);
ALTER TABLE SBI_I18N_MESSAGES ADD CONSTRAINT SBI_I18N_MESSAGES_UNIQUE UNIQUE (LANGUAGE_CD, LABEL, ORGANIZATION);

INSERT INTO hibernate_sequences VALUES ('SBI_I18N_MESSAGES',
                                                            (SELECT COALESCE(MAX(m.ID) + 1, 1) FROM SBI_I18N_MESSAGES m));
COMMIT;                                                            
--- END ---

ALTER TABLE SBI_DATA_SET ADD CONSTRAINT XAK1SBI_DATA_SET UNIQUE (NAME, VERSION_NUM, ORGANIZATION);

ALTER TABLE SBI_ATTRIBUTE ADD COLUMN LOV_ID INTEGER NULL,
						  ADD COLUMN ALLOW_USER SMALLINT DEFAULT '1',
	   					  ADD COLUMN MULTIVALUE SMALLINT DEFAULT '0',
	   					  ADD COLUMN SYNTAX SMALLINT,
	   					  ADD COLUMN VALUE_TYPE_ID INTEGER NULL,
	   					  ADD COLUMN VALUE_TYPE_CD VARCHAR(20),
	   					  ADD COLUMN VALUE_TYPE VARCHAR(50);
	   					  
ALTER TABLE SBI_ATTRIBUTE ADD CONSTRAINT FK_LOV FOREIGN KEY (LOV_ID) REFERENCES SBI_LOV(LOV_ID);
ALTER TABLE SBI_ATTRIBUTE ADD CONSTRAINT ENUM_TYPE CHECK (VALUE_TYPE IN('STRING','DATE','NUM'));

ALTER TABLE SBI_ATTRIBUTE ALTER COLUMN DESCRIPTION DROP NOT NULL;

ALTER TABLE SBI_EVENTS_LOG ADD COLUMN EVENT_TYPE VARCHAR(50) DEFAULT 'SCHEDULER' NOT NULL;

UPDATE SBI_EVENTS_LOG SET EVENT_TYPE = (
CASE HANDLER 
	WHEN 'it.eng.spagobi.events.handlers.DefaultEventPresentationHandler' THEN 'SCHEDULER'
	WHEN 'it.eng.spagobi.events.handlers.CommonjEventPresentationHandler' THEN 'COMMONJ'
	WHEN 'it.eng.spagobi.events.handlers.TalendEventPresentationHandler' THEN 'ETL'
	WHEN 'it.eng.spagobi.events.handlers.WekaEventPresentationHandler' THEN 'DATA_MINING'
END
);
commit;

ALTER TABLE SBI_EVENTS_LOG DROP COLUMN HANDLER;

ALTER TABLE SBI_OUTPUT_PARAMETER ALTER FORMAT_VALUE TYPE CHARACTER VARYING(30);