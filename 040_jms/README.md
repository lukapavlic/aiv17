# Projekt, ki demonstrira sporo�ilna zrna

V prijektu je ve� sporo�ilnih zrn:
- **AIVMessageDriven** (prijavljen na vrsto: jms/queue/test)
- **AIVMessageDrivenTopic** (prijavljen na vrsto: jms/topic/test)
- **VrstaBean** (prijavljen na vrsto: jms/queue/test)

Zrno VrstaBean demonstrira J2EE na�rtovalski vzorec **"Service Activator"** - odjemalcem omogo�a asinhrono pro�enje EJB metode Zrno.metoda().


*Predpogoji: na stre�niku je potrebno aktivirati dodatek JMS (v WildFly 10.1 je to ActiveMQ), dodati sporo�ilne vrste in teme ter dodati aplikacijskega uporabnika.*