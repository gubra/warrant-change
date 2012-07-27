create table warrant (
	id_ LONG not null primary key,
	userId LONG,
	summary VARCHAR(75) null,
	quantity INTEGER,
	price LONG,
	status VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	expirationWarningSent BOOLEAN
);