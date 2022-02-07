package com.penndot.redisstorage;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class RedisGreetingRepo {

	@Cacheable(value = "POC-----------Repo-Value", key = "#name")
	public String setRedisData(String name) {
		
		String str = makeBigStrng();
		System.out.println("in setRedisData()");
		return str;
	}
	
	private String makeBigStrng() {
    	String str = "Some things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software EngineerSome things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software EngineerSome things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software EngineerSome things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software EngineerSome things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software EngineerSome things you didn’t know about kubectl\r\n" + 
    			"Wednesday, October 28, 2015\r\n" + 
    			"kubectl is the command line tool for interacting with Kubernetes clusters. Many people use it every day to deploy their container workloads into production clusters. But there’s more to kubectl than just kubectl create -f or kubectl rolling-update. kubectl is a veritable multi-tool of container orchestration and management. Below we describe some of the features of kubectl that you may not have seen.\r\n" + 
    			"\r\n" + 
    			"Important Note : Most of these features are part of the upcoming 1.1 release of Kubernetes. They are not present in the current stable 1.0.x release series.\r\n" + 
    			"\r\n" + 
    			"Run interactive commands\r\n" + 
    			"kubectl run has been in kubectl since the 1.0 release, but recently we added the ability to run interactive containers in your cluster. That means that an interactive shell in your Kubernetes cluster is as close as:\r\n" + 
    			"\r\n" + 
    			"$> kubectl run -i --tty busybox --image=busybox --restart=Never -- sh   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Pending, pod ready: false   \r\n" + 
    			"Waiting for pod default/busybox-tv9rm to be running, status is Running, pod ready: false   \r\n" + 
    			"$> # ls \r\n" + 
    			"bin dev etc home proc root sys tmp usr var \r\n" + 
    			"$> # exit  \r\n" + 
    			"The above kubectl command is equivalent to docker run -i -t busybox sh. Sadly we mistakenly used -t for template in kubectl 1.0, so we need to retain backwards compatibility with existing CLI user. But the existing use of -t is deprecated and we’ll eventually shorten --tty to -t.\r\n" + 
    			"\r\n" + 
    			"In this example, -i indicates that you want an allocated stdin for your container and indicates that you want an interactive session, --restart=Never indicates that the container shouldn’t be restarted after you exit the terminal and --tty requests that you allocate a TTY for that session.\r\n" + 
    			"\r\n" + 
    			"View your Pod’s logs\r\n" + 
    			"Sometimes you just want to watch what’s going on in your server. For this, kubectl logs is the subcommand to use. Adding the -f flag lets you live stream new logs to your terminal, just like tail -f.\r\n" + 
    			"$> kubectl logs -f redis-izl09\r\n" + 
    			"\r\n" + 
    			"Attach to existing containers\r\n" + 
    			"In addition to interactive execution of commands, you can now also attach to any running process. Like kubectl logs, you’ll get stderr and stdout data, but with attach, you’ll also be able to send stdin from your terminal to the program. Awesome for interactive debugging, or even just sending ctrl-c to a misbehaving application.\r\n" + 
    			"\r\n" + 
    			"      $> kubectl attach redis -i\r\n" + 
    			"1:C 12 Oct 23:05:11.848 # Warning: no config file specified, using the default config. In order to specify a config file use redis-server /path/to/redis.conf\r\n" + 
    			"\r\n" + 
    			"                _._                                                  \r\n" + 
    			"           _.-``__''-._                                             \r\n" + 
    			"      _.-`` `. `_. ''-._ Redis 3.0.3 (00000000/0) 64 bit\r\n" + 
    			"  .-`` .-```. ```\\/ _.,_ ''-._                                   \r\n" + 
    			" ( ' , .-` | `, ) Running in standalone mode\r\n" + 
    			" |`-._`-...-` __...-.``-._|'` _.-'| Port: 6379\r\n" + 
    			" | `-._ `._ / _.-' | PID: 1\r\n" + 
    			"  `-._ `-._ `-./ _.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' | http://redis.io\r\n" + 
    			"`-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			" |`-._`-._ `-.__.-' _.-'_.-'|                                  \r\n" + 
    			" | `-._`-._ _.-'_.-' |                                  \r\n" + 
    			"  `-._ `-._`-.__.-'_.-' _.-'                                   \r\n" + 
    			"      `-._ `-.__.-' _.-'                                       \r\n" + 
    			"          `-._ _.-'                                           \r\n" + 
    			"              `-.__.-'                                               \r\n" + 
    			"\r\n" + 
    			"1:M 12 Oct 23:05:11.849 # Server started, Redis version 3.0.3\r\n" + 
    			"Forward ports from Pods to your local machine\r\n" + 
    			"Often times you want to be able to temporarily communicate with applications in your cluster without exposing them to the public internet for security reasons. To achieve this, the port-forward command allows you to securely forward a port on your local machine through the kubernetes API server to a Pod running in your cluster. For example:\r\n" + 
    			"\r\n" + 
    			"$> kubectl port-forward redis-izl09 6379\r\n" + 
    			"\r\n" + 
    			"Opens port 6379 on your local machine and forwards communication to that port to the Pod or Service in your cluster. For example, you can use the ‘telnet’ command to poke at a Redis service in your cluster:\r\n" + 
    			"\r\n" + 
    			"$> telnet localhost 6379   \r\n" + 
    			"INCR foo   \r\n" + 
    			":1   \r\n" + 
    			"INCR foo \r\n" + 
    			":2  \r\n" + 
    			"Execute commands inside an existing container\r\n" + 
    			"In addition to being able to attach to existing processes inside a container, the “exec” command allows you to spawn new processes inside existing containers. This can be useful for debugging, or examining your pods to see what’s going on inside without interrupting a running service. kubectl exec is different from kubectl run, because it runs a command inside of an existing container, rather than spawning a new container for execution.\r\n" + 
    			"\r\n" + 
    			"$> kubectl exec redis-izl09 -- ls /\r\n" + 
    			"bin\r\n" + 
    			"boot\r\n" + 
    			"data\r\n" + 
    			"dev\r\n" + 
    			"entrypoint.sh\r\n" + 
    			"etc\r\n" + 
    			"home\r\n" + 
    			"Add or remove Labels\r\n" + 
    			"Sometimes you want to dynamically add or remove labels from a Pod, Service or Replication controller. Maybe you want to add an existing Pod to a Service, or you want to remove a Pod from a Service. No matter what you want, you can easily and dynamically add or remove labels using the kubectl label subcommand:\r\n" + 
    			"\r\n" + 
    			"$> kubectl label pods redis-izl09 mylabel=awesome \r\n" + 
    			"pod \"redis-izl09\" labeled\r\n" + 
    			"\r\n" + 
    			"Add annotations to your objects\r\n" + 
    			"Just like labels, you can add or remove annotations from API objects using the kubectl annotate subcommand. Unlike labels, annotations are there to help describe your object, but aren’t used to identify pods via label queries (more details on annotations). For example, you might add an annotation of an icon for a GUI to use for displaying your pods.\r\n" + 
    			"\r\n" + 
    			"$> kubectl annotate pods redis-izl09 icon-url=http://goo.gl/XXBTWq \r\n" + 
    			"pod \"redis-izl09\" annotated\r\n" + 
    			"\r\n" + 
    			"Output custom format\r\n" + 
    			"Sometimes, you want to customize the fields displayed when kubectl summarizes an object from your cluster. To do this, you can use the custom-columns-file format. custom-columns-file takes in a template file for rendering the output. Again, JSONPath expressions are used in the template to specify fields in the API object. For example, the following template first shows the number of restarts, and then the name of the object:\r\n" + 
    			"\r\n" + 
    			"$> cat cols.tmpl   \r\n" + 
    			"RESTARTS                                   NAME   \r\n" + 
    			".status.containerStatuses[0].restartCount .metadata.name  \r\n" + 
    			"If you pass this template to the kubectl get pods command you get a list of pods with the specified fields displayed.\r\n" + 
    			"\r\n" + 
    			" $> kubectl get pods redis-izl09 -o=custom-columns-file --template=cols.tmpl                 RESTARTS           NAME   \r\n" + 
    			" 0                  redis-izl09   \r\n" + 
    			" 1                  redis-abl42  \r\n" + 
    			"Easily manage multiple Kubernetes clusters\r\n" + 
    			"If you’re running multiple Kubernetes clusters, you know it can be tricky to manage all of the credentials for the different clusters. Using the kubectl config subcommands, switching between different clusters is as easy as:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config use-context\r\n" + 
    			"Not sure what clusters are available? You can view currently configured clusters with:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view\r\n" + 
    			"Phew, that outputs a lot of text. To restrict it down to only the things we’re interested in, we can use a JSONPath template:\r\n" + 
    			"\r\n" + 
    			"        $> kubectl config view -o jsonpath=\"{.context[*].name}\"\r\n" + 
    			"Ahh, that’s better.\r\n" + 
    			"\r\n" + 
    			"Conclusion\r\n" + 
    			"So there you have it, nine new and exciting things you can do with your Kubernetes cluster and the kubectl command line. If you’re just getting started with Kubernetes, check out Google Container Engine or other ways to get started with Kubernetes.\r\n" + 
    			"\r\n" + 
    			"Brendan Burns, Google Software Engineer";
    	return str;
    }
}
