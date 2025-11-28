import React from "react";
import { useAuth } from "../context/AuthContext";

const ProtectedRoute = ({children}) =>{
    const{token} = useAuth()
}

export default ProtectedRoute