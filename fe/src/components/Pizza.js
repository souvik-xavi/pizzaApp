import React, {useState, useEffect} from 'react'
import axios from 'axios';
import './pizza.css';

const Pizza = () => {
    const [pizzas, setPizzas] = useState([]);

<<<<<<< HEAD
    const viewPizza = async (e) => {
      const res = await fetch(`http://localhost:8080/viewPizza`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        }
      });
  
      const data = await res.json();
      console.log(data);
  
      if (res.status === 404 || !data) {
        window.alert("Error: Data Not Fetch");
        console.log("Data Not Fetch");
      } else {
        setPizzas(data);
        // window.alert("Data Fetch Successfully");
        console.log("1" + pizzas)
=======
    const viewPizza = async ()=>{
      try {
        const res = await axios.get(`http://localhost:8080/viewPizza`);
        console.log(res.data);
      } catch (error) {
        console.log("Error Found")
>>>>>>> b7f465d3aad04d737296c0889b44c09a62f1497f
      }
      
     

    };
  
    useEffect(()=>{
      viewPizza()
    },[])
  
  return (
    <>
      <h1 className='heading'>View Pizza</h1>
      <div className="card_body">
        <div className="card">
          {
            pizzas.map((val)=>{
              return(
                <>
                  {/* <p>{val.}</p> */}
                  <p>{val.pizzaType}</p>
                  <p>{val.pizzaName}</p>
                  <p>{val.pizzaDescription} </p>
                  <p>{val.pizzaCost}</p>
                </>
              )
            })
          }
        </div>
      </div>

    </>
)
}

export default Pizza