import axios from "axios";

const URI = "http://115.85.181.92:8090";

export const fetchPost = async () => {
	const res = await axios.get(URI + '/lecture');
	return res.data;
}

export const fetchLogin = async (id: string, password: string) => {
	const res = await axios.post(URI + '/login', {
		id: id,
		password: password,
	});
	return res.data;
}