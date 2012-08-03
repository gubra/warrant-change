create table warrant (
	id_ LONG not null primary key,
	userId LONG,
	summary VARCHAR(75) null,
	quantity INTEGER,
	price DOUBLE,
	status VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	expirationWarningSent BOOLEAN
);

create table warrantUserEmailLog (
	id_ LONG not null primary key,
	subject VARCHAR(75) null,
	bodyContent VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table warrantUserUniqueId (
	id_ LONG not null primary key,
	uniqueId VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	sentEmail VARCHAR(75) null,
	sentDate DATE null,
	sentOmicode VARCHAR(75) null
);