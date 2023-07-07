NAME = UnderTheC

all : $(NAME)

$(NAME) :
	docker compose up --build -d

cmd:
	docker compose $(COMMAND)

start:
	docker compose start $(CONTAINER)
stop:
	docker compose stop $(CONTAINER)
restart:
	docker compose restart $(CONTAINER)


clean :
	docker compose down --remove-orphans --rmi all --volumes

fclean : clean
	docker network prune --force
	docker volume prune --force
	docker system prune --all --force --volumes
	rm -rf db-mariadb/data
	cd backend-spring && ./gradlew clean

re : fclean all
