
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

✅​ Pruebas

- Primero iniciamos **rmiregistry 50000** en una terminal:

<p align="center">
<img width="742" height="133" alt="image" src="https://github.com/user-attachments/assets/002ad3b5-31c5-4384-8047-8a210e8d8194" />
</p>

- Luego iniciamos a Alice en otra terminal:

<p align="center">
<img width="1067" height="53" alt="image" src="https://github.com/user-attachments/assets/cf059106-523c-4908-8c5a-e3698db8601d" />
</p>

- Inicamos a Bob en otra terminal diferente a las que ya tenemos:

<p align="center">
<img width="742" height="133" alt="image" src="https://github.com/user-attachments/assets/002ad3b5-31c5-4384-8047-8a210e8d8194" />
</p>

- Empezamos a mandar mensajes y vemos como se pueden ir respondiendo:

<p align="center">
<img width="1050" height="135" alt="image" src="https://github.com/user-attachments/assets/81a7d887-7cbf-40c8-9dfe-5a988c96176f" />
</p>

<p align="center">
<img width="1219" height="123" alt="image" src="https://github.com/user-attachments/assets/316a8e9a-ad04-4a01-9f02-0d8b04dd58e3" />
</p>
  
