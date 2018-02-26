delete from invoice where vehicle = (select id from vehicle WHERE PLAQUE = 'ESK43B');
delete from vehicle WHERE plaque = 'ESK43B';
delete from user where user = 'admin';
delete from user where user = 'adminadmin';
delete from rate where rate_name = 'Tarifa2';
delete from invoice where vehicle = 33 and rate = 11;
update invoice set dateoutput=null,timeparking=0,valuepay=0 where id = 27;