insert into categoria values("1","tecnologia");
insert into categoria values("2","electrodomesticos");
insert into categoria values("3","jardineria");

insert into ciudad values("1","armenia");
insert into ciudad values("2","pereira");
insert into ciudad values("3","arauca");

insert into persona values("Usuario","1","sebastian@gmail.com","sebastian","contrasenia","1");
insert into persona values("Administrador","2","santiago@gmail.com","santiago","i2k3n24","3");
insert into persona values("Persona","3","pavlo@gmail.com","pavlo","fokakjd56","2");

insert into producto values("1","este producto corta",5,"2025/09/12","cuchillo",15000,4,"1","1");
insert into producto values("2","este producto moja",8,"2025/01/12","mangera",10000,42,"2","1");
insert into producto values("3","este producto sopla",1,"2025/09/11","soplador",40000,1,"3","1");

insert into categoria_productos values("1","3");
insert into categoria_productos values("1","2");
insert into categoria_productos values("1","1");

insert into chat values("1","1","1");
insert into chat values("2","1","2");
insert into chat values("3","1","3");

insert into mensaje values("1","2025/09/12","mesnaje1","1");
insert into mensaje values("2","2025/09/12","mesnaje2","2");
insert into mensaje values("3","2025/09/12","mesnaje3","1");

insert into compra values("1","2025/09/12","1");
insert into compra values("2","2025/01/12","1");
insert into compra values("3","2025/09/18","1");


insert into detalle_compra values ("1",15000,1,"1","1");
insert into detalle_compra values ("2",10000,3,"2","2");
insert into detalle_compra values ("3",40000,2,"3","3");

insert into subasta values ("1","2025/09/18","1");
insert into subasta values ("2","2025/09/11","2");
insert into subasta values ("3","2025/09/30","3");

insert into  comentario values ("1",1,"2025/09/30","mensaje1","respuesta1","1","1");
insert into  comentario values ("2",2,"2025/01/30","mensaje2","respuesta2","2","1");
insert into  comentario values ("3",3,"2025/09/23","mensaje3","respuesta3","3","1");


insert into detalle_subasta values ("1","2025/09/18",40000,"1","1");
insert into detalle_subasta values ("2","2025/09/11",10000,"2","1");
insert into detalle_subasta values ("3","2025/09/01",22000,"3","1");












