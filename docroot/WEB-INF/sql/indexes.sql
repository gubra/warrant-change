create index IX_B3D205E1 on warrant (createDate);
create index IX_560570EE on warrant (createDate, status, expirationWarningSent);
create index IX_B7C8FF89 on warrant (status);
create index IX_594818DD on warrant (userId);

create unique index IX_AD9C207A on warrantUserUniqueId (uniqueId);
create index IX_84A02274 on warrantUserUniqueId (userId);