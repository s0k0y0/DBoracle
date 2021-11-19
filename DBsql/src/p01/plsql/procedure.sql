[결과]
2^3=8
I I  0
--a_exponent가 음수이면 값을 0으로 변경하고,1을 반환
create or replace procedure compute_power(
a_num in number,
a_exponent in out number,
a_power out number
)
is
begin
	if a_exponent<0 then
	a_exponent:=0;
	end if;
	a_power:=1;
	for i in 1..a_exponent loop
	a_power:=a_power*a_num;
	end loop;	
	
end;


create or replace procedure javatest(
	p1 in varchar2,
	p2 in out varchar2,
	p3 out varchar2
) as

begin
	
	p2:=p1||p2;
	p3:=p1;

end; 
