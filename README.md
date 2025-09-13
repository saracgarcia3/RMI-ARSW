
# 💬 RMI-ARSW: Chat Peer-to-Peer con Java RMI

Este proyecto implementa un **chat distribuido** usando **Java RMI**.  
Cada nodo puede publicar su objeto remoto y conectarse a otro peer para intercambiar mensajes.




## ▶️ Ejecución

### 1. Iniciar rmiregistry
En una terminal, dentro de la carpeta del proyecto:
```bash
mvn compile
cd target/classes
rmiregistry 50000 
```

### 2. Iniciar un peer (Alice)
```bash
mvn -q -Dexec.mainClass=edu.eci.networking.rmi.ChatNode exec:java -Dexec.args="alice 50001"
```

### 3. Iniciar otro peer (Bob)
En otra terminal:
```bash
mvn -q -Dexec.mainClass=edu.eci.networking.rmi.ChatNode exec:java -Dexec.args="bob 50001 127.0.0.1 50001 alice"
```

---

## 📖 Explicación

En la sección **6. Invocación remota de métodos: RMI**, se presenta la estructura básica de un sistema RMI con interfaz remota, implementación y cliente.  
El ejercicio **6.4.1** plantea la creación de un chat distribuido, que se adapta en este proyecto.

- Se definió una interfaz remota (ChatPeer) que extiende Remote y declara los métodos que pueden invocarse entre nodos (enviar y recibir mensajes).
- Se creó una implementación (ChatPeerImpl) que exporta el objeto remoto con UnicastRemoteObject, permitiendo que otros peers se conecten a él.
- La clase principal ChatNode permite que cada usuario levante un peer con un nombre y un puerto.
- Un peer puede publicar su objeto en el rmiregistry para que otros se conecten.
- También puede conectarse a otro peer indicando su IP, puerto y nombre.
- Una vez conectados, los mensajes que escribe un usuario se transmiten al otro en tiempo real, logrando comunicación peer-to-peer.