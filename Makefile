NAME = UnderTheC

all : $(NAME)

$(NAME) :
	docker compose up --build -d

clean :
	docker compose down --remove-orphans --rmi all --volumes

fclean : clean
	docker network prune --force
	docker volume prune --force
	docker system prune --all --force --volumes
# rm -rf ${HOME}/data

re : fclean all
