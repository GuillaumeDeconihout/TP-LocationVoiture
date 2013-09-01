package fr.treeptik.locationvoiture.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

import fr.treeptik.locationvoiture.exception.AspectException;

public class ConsoleNotifier {

	private Logger logger;

	@SuppressWarnings("rawtypes")
	public void afterReturning(StaticPart staticPart, Object result)
			throws AspectException {

		try {
			// Nom de la classe interceptée
			logger = Logger.getLogger(staticPart.getSignature()
					.getDeclaringTypeName());

			// Nom de la méthode interceptée
			String serviceMethod = staticPart.getSignature().getName();

			// Initialisation du message de log avec cette méthode
			StringBuilder builder = new StringBuilder();
			builder.append("[" + serviceMethod + "]").append("%Return% :");

			// On vérifie que l'objet renvoyé n'est pas null
			if (!(result == null)) {

				// Si l'objet retourné est un pojo on logue son état à l'aide de sa
				// méthode toString
				if (result.getClass().getName()
						.startsWith("fr.treeptik.locationvoiture.model")) {

					Method toStringMethod = result.getClass().getMethod(
							"toString");

					builder.append(toStringMethod.invoke(result));

					logger.debug(builder.toString());

				} // Sinon, si l'objet retourné est une liste, on logue le type
					// d'objet listé et la taille de la liste
				else if (result.getClass().getName()
						.equals("java.util.ArrayList")
						|| result.getClass().getName().equals("java.util.List")) {
					List list = (List) result;

					if (list.size() != 0) {
						builder.append(" list " + list.get(0).getClass())
								.append(" size " + list.size());
					} // Cas de la liste vide
					else {
						 builder.append(" empty list " +
						 list.getClass()).append(
						 " size 0");
					}
					logger.debug(builder);
				}
			}

		} catch (SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new AspectException(e.getMessage(), e.getCause());
		}

	}

	public void beforeSave(JoinPoint joinPoint) {

		// System.out.println("Signature  " +
		// joinPoint.getSignature().getName());
		// Object[] args = joinPoint.getArgs();
		// Contact c = (Contact) args[0];
		// c.setNom("Hack Contact");
		// System.out.println("Before save nom : " +c.getNom() );

	}
}
