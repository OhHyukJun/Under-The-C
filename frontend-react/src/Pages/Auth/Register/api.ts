import axios from "axios";
//import Member from './Member';

//const URI = "http://localhost:4000/members";
const URI = "${SPRING_HOST}:${SPRING_PORT}/user/add";

export const memberPost = async (data: any) => {
    const res = await axios.post(URI, data);
    return res.data;
  };